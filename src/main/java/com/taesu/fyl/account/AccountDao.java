package com.taesu.fyl.account;

import com.taesu.fyl.account.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dlxot on 2016-12-18.
 */
@Mapper
@Component
public interface AccountDao {

    int createAccount(AccountForInsert account);
    int createAccountAuthorityMapping(AccountForAuthorityMapping accountForAuthorityMapping);

    AccountForSecurity readAccountForSecurity(String userId);
    AccountForSelect readAccountById(String userId);
    List<AccountForSelect>  readAccount();

    int updateAccountById(AccountForUpdate account);
    int updateAccountPermitById(AccountForUpdate account);
    int updateAccountAuthorityMapping(AccountForAuthorityMapping accountForAuthorityMapping);

    int deleteAccountById(String userId);
    int deleteAccountAuthorityMapping(String userId);

    String readAuthTokenById(String userId);
}

