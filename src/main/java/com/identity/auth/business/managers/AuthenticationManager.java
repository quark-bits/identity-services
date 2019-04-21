package com.identity.auth.business.managers;

import com.identity.auth.business.resource.UserCredentials;

public interface AuthenticationManager {
    /**
     * Authenticate User
     *
     * @param userCredentials
     */
    Boolean authenticateUser(UserCredentials userCredentials);
}
