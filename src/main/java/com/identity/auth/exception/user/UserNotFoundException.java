package com.identity.auth.exception.user;

import com.identity.auth.AuthAppErrorCode;
import com.identity.auth.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
    @Override
    public int getCode() {
        return AuthAppErrorCode.USER_DOES_NOT_EXIST.getError_code();
    }

    @Override
    public String getDescription() {
        return AuthAppErrorCode.USER_DOES_NOT_EXIST.getError_desc();
    }
}
