package com.identity.auth.exception.user;

import com.identity.auth.AuthAppError;
import com.identity.auth.AuthAppErrorCode;

public class UserEmailExistsException extends Exception implements AuthAppError {

    private boolean suppressStacktrace = false;

    public UserEmailExistsException(String message, boolean suppressStacktrace) {
        super(message, null, suppressStacktrace, !suppressStacktrace);
        this.suppressStacktrace = suppressStacktrace;
    }

    @Override
    public int getCode() {
        return AuthAppErrorCode.USER_EMAIL_EXISTS.getError_code();
    }

    @Override
    public String getDescription() {
        return AuthAppErrorCode.USER_EMAIL_EXISTS.getError_desc();
    }
}
