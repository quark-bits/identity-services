package com.identity.auth.exception;

import com.identity.auth.AuthAppError;
import com.identity.auth.AuthAppErrorCode;

public class UnAuthorizedException extends Exception implements AuthAppError {
    @Override
    public int getCode() {
        return AuthAppErrorCode.UNAUTHORIZED.getError_code();
    }

    @Override
    public String getDescription() {
        return AuthAppErrorCode.UNAUTHORIZED.getError_desc();
    }
}
