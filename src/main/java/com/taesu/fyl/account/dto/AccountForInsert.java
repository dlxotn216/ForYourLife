package com.taesu.fyl.account.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by dlxot on 2016-12-21.
 */
@Data
public class AccountForInsert {

    private String userId;
    private String passwd;
    private String userName;
    private String userEmail;
    private Character emailYn;
    private Timestamp requestDate;
    private String premit;
    private String phone;
    private Character smsYn;

    private String authName;
}