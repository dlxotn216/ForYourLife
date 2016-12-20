package com.taesu.fyl.account.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by dlxot on 2016-12-18.
 */
@Data
public class AccountForSelect {
    private String id;
    private String password;
    private String name;
    private String email;
    private Character emailYn;
    private String phone;
    private Character smsYn;
    private Timestamp regDate;
}
