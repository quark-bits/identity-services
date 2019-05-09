package com.identity.auth.exception.user;

import com.identity.auth.AuthAppError;
import com.identity.auth.AuthAppErrorCode;

public class UserNameExistsException extends Exception implements AuthAppError {

    private boolean suppressStacktrace = false;

    public UserNameExistsException(String message, boolean suppressStacktrace) {
        super(message, null, suppressStacktrace, !suppressStacktrace);
        this.suppressStacktrace = suppressStacktrace;
    }

    @Override
    public int getCode() {
        return AuthAppErrorCode.USERNAME_EXISTS.getError_code();
    }

    @Override
    public String getDescription() {
        return AuthAppErrorCode.USERNAME_EXISTS.getError_desc();
    }
}
