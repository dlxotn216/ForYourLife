package com.taesu.fyl.account.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created by dlxot on 2016-12-21.
 */
@Data
public class AccountForUpdate {
    private String userId;
    private String passwd;
    private String userName;
    private String userEmail;
    private Timestamp requestDate;

    private String authName;
    private String permit;
}
