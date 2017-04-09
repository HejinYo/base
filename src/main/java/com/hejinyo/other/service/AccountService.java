package com.hejinyo.other.service;

import com.hejinyo.other.domain.Account;

import java.util.List;

/**
 * Account service 接口
 */
public interface AccountService {
    public List<Account> getAllAccounts(Account account);
    public List<Account> getTest(String account);

}
