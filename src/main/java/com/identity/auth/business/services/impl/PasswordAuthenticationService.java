package com.identity.auth.business.services.impl;

import com.identity.auth.AuthAppConstants;
import com.identity.auth.AuthAppErrorCode;
import com.identity.auth.business.managers.AuthenticationManager;
import com.identity.auth.business.resource.UserCredentials;
import com.identity.auth.business.services.AuthenticationService;
import com.identity.auth.exception.UnAuthorizedException;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component("passwordAuthentication")
@Path("/v1/auth/password")

public class PasswordAuthenticationService implements AuthenticationService {

    private final AuthenticationManager authenticationManager;

    public PasswordAuthenticationService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response authenticate(UserCredentials userCredentials) {
        Boolean isAuthenticated = authenticationManager.authenticateUser(userCredentials);
        if(isAuthenticated){
            return Response
                    .status(Response.Status.OK.getStatusCode())
                    .entity(AuthAppConstants.SUCCESS)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        return Response
                .status(Response.Status.UNAUTHORIZED.getStatusCode())
                .entity(AuthAppConstants.FAILURE)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
