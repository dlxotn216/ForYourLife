package com.taesu.fyl.account;

import com.taesu.fyl.account.dto.AccountForSelect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dlxot on 2016-12-18.
 */
@Service
@Slf4j
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
