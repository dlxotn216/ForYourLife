package com.taesu.fyl.account.dto;

import lombok.Data;

/**
 * Created by kim on 2016-11-29.
 */
@Data
public class AccountForSecurity {
    private String userId;
    private String passwd;
    private String permit;

    public AccountForSecurity(){

    }
    public AccountForSecurity(String userId){
        this.userId = userId;
    }
}
