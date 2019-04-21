package com.identity.auth.business.managers.proxy;

import com.identity.auth.business.resource.User;
import com.identity.auth.business.managers.UserManager;
import com.identity.auth.business.managers.impl.DefaultUserManager;
import com.identity.auth.business.resource.UserCredentials;
import com.identity.auth.exception.UnAuthorizedException;
import com.identity.auth.exception.user.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Manger Proxy to check permissions.
 *
 */
@Component("userManager")
public class UserManagerProxy implements UserManager {

    @Autowired
    private DefaultUserManager userManager;


    @Override
    public Optional<User> createUser(User user) throws UserExistsException {
        return userManager.createUser(user);
    }

    @Override
    public Optional<User> getUser(String userName) {
        return userManager.getUser(userName);
    }

    @Override
    public Optional<UserCredentials> getUserCredentials(User user) {
        return userManager.getUserCredentials(user);
    }
}
