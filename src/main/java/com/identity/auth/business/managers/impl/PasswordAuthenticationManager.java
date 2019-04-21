package com.identity.auth.business.managers.impl;

import com.identity.auth.business.managers.AuthenticationManager;
import com.identity.auth.business.managers.UserManager;
import com.identity.auth.business.resource.User;
import com.identity.auth.business.resource.UserCredentials;
import com.identity.auth.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("PasswordAuthenticationManager")
public class PasswordAuthenticationManager implements AuthenticationManager {

    @Autowired
    UserManager userManager;

    @Override
    public Boolean authenticateUser(UserCredentials userCredentials) {
        Optional<User> user = userManager.getUser(userCredentials.getUserName());
        if(user.isPresent()){
            Optional<UserCredentials> dbUserCredentials = userManager.getUserCredentials(user.get());
            String storedEncryptedPassword = new String(dbUserCredentials.get().getPassword());
            return EncryptionUtils.verifyPassword(storedEncryptedPassword,new String(userCredentials.getPassword()));
        }
        return Boolean.FALSE;
    }
}
