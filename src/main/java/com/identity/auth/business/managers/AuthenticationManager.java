package com.identity.auth.business.managers;

import com.identity.auth.business.resource.UserCredentials;

/**
 * Manage Authentication
 */
public interface AuthenticationManager {
    /**
     * Authenticate User
     *
     * @param userCredentials
     */
    Boolean authenticateUser(UserCredentials userCredentials);
}
