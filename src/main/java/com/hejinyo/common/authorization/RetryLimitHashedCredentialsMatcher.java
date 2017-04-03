package com.hejinyo.common.authorization;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 账户登录多次失败锁定
 *
 * @author HejinYo
 * @version 1.0
 * @email hejinyo@gmail.com
 * @since 1.0
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> loginRecordCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        //获得缓存配置
        loginRecordCache = cacheManager.getCache("loginRecordCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String) token.getPrincipal();
        AtomicInteger retryCount = loginRecordCache.get(username);
        if (retryCount == null) {//如果缓存中没有，就为用户创建一个
            retryCount = new AtomicInteger(0);
            loginRecordCache.put(username, retryCount);
        }
        if (retryCount.incrementAndGet() > 5) {//每次执行登录增加一次，大于5次，抛出异常
            throw new ExcessiveAttemptsException();
        }
        boolean matches = super.doCredentialsMatch(token, info);
        if (matches) {//认证成功，清除登陆执行次数
            loginRecordCache.remove(username);
        }
        return matches;
    }
}
