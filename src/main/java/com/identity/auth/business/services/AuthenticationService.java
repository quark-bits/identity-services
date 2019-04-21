package com.identity.auth.business.services;

import com.identity.auth.business.resource.UserCredentials;

import javax.ws.rs.core.Response;

public interface AuthenticationService {
    Response authenticate(UserCredentials userCredentials);
}
