package com.identity.auth.exception;

import com.identity.auth.AuthAppError;
import com.identity.auth.AuthAppErrorCode;
import com.identity.auth.exception.user.UserEmailExistsException;
import org.springframework.dao.DataIntegrityViolationException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataIntegrityViolationExceptionMapper implements
        ExceptionMapper<DataIntegrityViolationException> {
    @Override
    public Response toResponse(DataIntegrityViolationException exception) {
        return Response
                .status(Response.Status.CONFLICT)
                .entity(new UserEmailExistsException(AuthAppErrorCode.USER_EMAIL_EXISTS.getError_desc(),true))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

}
