package com.hejinyo.service.other;

import com.hejinyo.pojo.other.Account;

import java.util.List;

/**
 * Account service 接口
 */
public interface AccountService {
    public List<Account> getAllAccounts(Account account);
    public List<Account> getTest(String account);

}
