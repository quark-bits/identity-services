package com.identity.auth;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum AuthAppErrorCode {
    UNAUTHORIZED(401, "UnAuthorized"),

    USERNAME_EXISTS(2001,"Username Already exists."),
    INVALID_EMAIL_ID(2002,"Invalid Email Id."),
    INVALID_EMAIL_DOMAIN(2003,"This Email Domain not allowed."),
    INVALID_CREDENTIALS(2004,"Incorrect UserName or Password."),
    USER_DOES_NOT_EXIST(2005,"User does not exists.");


    private final int error_code;
    private final String error_desc;

    AuthAppErrorCode(int error_code, String error_desc) {
        this.error_code = error_code;
        this.error_desc = error_desc;
    }
}

