package com.taesu.fyl.account;

import com.taesu.fyl.account.dto.AccountForSelect;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dlxot on 2016-12-18.
 */
@Mapper
@Component
public interface AccountDao {
    List<AccountForSelect> readAccount();
    AccountForSelect readAccountById(String id);
}
