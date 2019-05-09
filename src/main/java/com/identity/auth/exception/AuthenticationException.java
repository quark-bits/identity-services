package com.identity.auth.exception;

import com.identity.auth.AuthAppError;
import com.identity.auth.AuthAppErrorCode;

public class AuthenticationException extends Exception implements AuthAppError {
    @Override
    public int getCode() {
        return AuthAppErrorCode.INVALID_CREDENTIALS.getError_code();
    }

    @Override
    public String getDescription() {
        return AuthAppErrorCode.INVALID_CREDENTIALS.getError_desc();
    }
}
