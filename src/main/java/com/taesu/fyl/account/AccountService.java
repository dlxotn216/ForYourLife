package com.taesu.fyl.account;

import com.taesu.fyl.account.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by dlxot on 2016-12-18.
 */

@Slf4j
@Service
public class AccountService {


    @Autowired
    private AccountDao accountDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AccountForSecurity readAccountForSecurity(String userId){
        return accountDao.readAccountForSecurity(userId);
    }

    public AccountForSelect readAccountById(String userId){
        return accountDao.readAccountById(userId);
    }

    @Transactional
    public void createAccount(AccountForInsert account){
        account.setRequestDate(new Timestamp(System.currentTimeMillis()));
        account.setPasswd(passwordEncoder.encode(account.getPasswd()));
        account.setAuthName("ROLE_USER");               //초기 회원가입은 사용자로

        AccountForAuthorityMapping accountForAuthorityMapping = new AccountForAuthorityMapping();
        accountForAuthorityMapping.setUserId(account.getUserId());
        accountForAuthorityMapping.setAuthName(account.getAuthName());

        accountDao.createAccount(account);
        accountDao.createAccountAuthorityMapping(accountForAuthorityMapping);
    }

    /**
     *
     * @param account
     * @param userId
     * @return
     */
    @Transactional
    public int updateAccountById(AccountForUpdate account, String userId){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Object pricinpal = auth.getPrincipal();
        System.out.println("DEBUG update account [pricipal : "+pricinpal+"  userId: "+userId+"]");

        if(!userId.equals(pricinpal.toString())){
            return -1;
        }
        account.setPasswd(passwordEncoder.encode(account.getPasswd()));
        return accountDao.updateAccountById(account);
    }
    @Autowired
    private SessionRegistry sessionRegistry;
    private void changeSecurityToken(String userId){
        List<Object> loggedUsers = sessionRegistry.getAllPrincipals();
        for (Object principal :loggedUsers) {
            if (principal instanceof User) {
                UserDetails userDetails = (UserDetails) principal;
                System.out.println(userDetails.getUsername()+" "+userId);
                if (userDetails.getUsername().equals(userId)) {
                    for (SessionInformation information : sessionRegistry.getAllSessions(userDetails, true)) {
                        information.expireNow();
                    }
                }
            }
        }
    }

    @Transactional
    public int updateAccountById(AccountForUpdate account, String userId, boolean isMaster){

        System.out.println("DEBUG update account by MASTER[userId: "+userId+"]");
        account.setUserId(userId);


        AccountForAuthorityMapping accountForAuthorityMapping
                = new AccountForAuthorityMapping();
        accountForAuthorityMapping.setUserId(account.getUserId());
        accountForAuthorityMapping.setAuthName(account.getAuthName());

        this.changeSecurityToken(account.getUserId());

        int result = accountDao.updateUserAccountById(account)
                & accountDao.updateAccountAuthorityMapping(accountForAuthorityMapping);;
        return result;
    }

    /**
     * 전달된 id에 대해 delete 수행
     * 현재 세션에 로그인 된 사용자와 요청받은 삭제 대상이 같은지 비교
     * 모든 사용자 호출 가능
     * @param userId
     * @return
     */
    @Transactional
    public int deleteAccount(String userId){
        Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        Object pricinpal = auth.getPrincipal();
        System.out.println("DEBUG delete account [pricipal : "+pricinpal+"  userId: "+userId+"]");

        if(!userId.equals(pricinpal.toString())){
            return -1;
        }

        int result = accountDao.deleteAccountAuthorityMapping(userId)
                & accountDao.deleteAccountById(userId);
        return result;
    }

    /**
     * 전달된 사용자 id에 대해 delete 수행
     * ROLE_MASTER만 호출 가능
     * @param userId
     * @param isMaster
     * @return
     */
    @Transactional
    public int deleteAccount(String userId, boolean isMaster){
        System.out.println("DEBUG delete Master account [userId: "+userId+"]");
        int result = accountDao.deleteAccountAuthorityMapping(userId)
                & accountDao.deleteAccountById(userId);
        this.changeSecurityToken(userId);

        return result;
    }

    public List<AccountForSelect> readAllAccount(){
        return accountDao.readAccount();
    }
}
