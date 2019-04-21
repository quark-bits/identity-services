package com.identity.auth.exception;

import com.identity.auth.AuthAppError;
import com.identity.auth.AuthAppErrorCode;

public class UserExistsException extends Exception implements AuthAppError {
    @Override
    public int getCode() {
        return AuthAppErrorCode.USERNAME_EXISTS.getError_code();
    }

    @Override
    public String getDescription() {
        return AuthAppErrorCode.USERNAME_EXISTS.getError_desc();
    }
}
