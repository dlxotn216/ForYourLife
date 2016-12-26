package com.taesu.fyl.account.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by dlxot on 2016-12-18.
 */
@Data
public class AccountForSelect {
    private String userId;
    private String passwd;
    private String userName;
    private String userEmail;
    private Character emailYn;
    private String phone;
    private Character smsYn;
    private Timestamp regDate;
    private String permit;
}
