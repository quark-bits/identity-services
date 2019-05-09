package com.identity.auth.business.managers.impl;

import com.identity.auth.business.managers.AuthenticationManager;
import com.identity.auth.business.managers.UserManager;
import com.identity.auth.business.resource.User;
import com.identity.auth.business.resource.UserCredentials;
import com.identity.auth.events.user.UserEvent;
import com.identity.auth.events.user.UserObservable;
import com.identity.auth.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Authentication Manager that supports username/password based Authentication.
 */
@Component("PasswordAuthenticationManager")
public class PasswordAuthenticationManager implements AuthenticationManager {

    @Autowired
    UserManager userManager;

    @Override
    public Boolean authenticateUser(UserCredentials userCredentials) {
        Boolean isAuthSucess = Boolean.FALSE;

        // check if user with the supplied username exists?
        Optional<User> user = userManager.getUser(userCredentials.getUserName());

        if(user.isPresent()){
            // verify if password is valid?
            Optional<UserCredentials> dbUserCredentials = userManager.getUserCredentials(user.get());
            String storedEncryptedPassword = new String(dbUserCredentials.get().getPassword());

            isAuthSucess = EncryptionUtils.verifyPassword(storedEncryptedPassword,new String(userCredentials.getPassword()));

            // Create UserEvent
            UserEvent.UserEventBuilder userEventBuilder = new UserEvent.UserEventBuilder(user.get().getId(),user.get().getObjectType());

            if(isAuthSucess){
                // Fire Login Success Event
                userEventBuilder.setEventType(UserEvent.UserEventType.LOGIN_SUCCESS);
            }
            else{
                // Fire Login Failure Event
                userEventBuilder.setEventType(UserEvent.UserEventType.LOGIN_FAILURE);
            }
            UserEvent userEvent = userEventBuilder.build();

            // Publish Event
            UserObservable.INSTANCE.notifyObservers(userEvent);
        }
        return isAuthSucess;
    }
}
