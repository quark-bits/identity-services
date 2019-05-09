package com.identity.auth.business.managers;

import com.identity.auth.business.resource.User;
import com.identity.auth.business.resource.UserCredentials;
import com.identity.auth.exception.user.UserNameExistsException;

import java.util.Optional;

public interface UserManager {
    /**
     * Create User
     *
     * @param user
     * @return
     */
    Optional<User> createUser(User user) throws UserNameExistsException;


    /**
     * Get User for username
     *
     * @param userName
     * @return
     */
    Optional<User> getUser(String userName);


    /**
     * Get User Credentials
     *
     * @param user
     * @return
     */
    Optional<UserCredentials> getUserCredentials(User user);
}
