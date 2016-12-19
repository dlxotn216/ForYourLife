package com.taesu.fyl.account;

import com.taesu.fyl.account.dto.AccountForSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dlxot on 2016-12-18.
 */
@Service
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    public List<AccountForSelect> readAccount(){
        return accountDao.readAccount();
    }
    public AccountForSelect readAccountById(String id){
        return accountDao.readAccountById(id);
    }
}
