package com.identity.auth.business.managers.proxy;

import com.identity.auth.business.managers.AuthenticationManager;
import com.identity.auth.business.managers.impl.PasswordAuthenticationManager;
import com.identity.auth.business.resource.UserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Proxy class to check for permissions
 *
 */
@Component("authenticationManager")
public class AuthenticationManagerProxy implements AuthenticationManager {

    @Autowired
    private PasswordAuthenticationManager authenticationManager;

    @Override
    public Boolean authenticateUser(UserCredentials userCredentials) {
        return authenticationManager.authenticateUser(userCredentials);
    }
}
