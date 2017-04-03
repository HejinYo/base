package com.hejinyo.mapper.other;

import com.hejinyo.mapper.BaseMapper;
import com.hejinyo.pojo.other.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper extends BaseMapper{
    /**
     * 返回Account 所有的记录
     * @return List<Accounts>
     */
    public List<Account> getAllAccounts(Account account);
    public List<Account> getTest(String account);
}
