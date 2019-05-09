package com.identity.auth.business.services;

import com.identity.auth.business.resource.User;
import com.identity.auth.exception.user.UserNameExistsException;

import javax.ws.rs.core.Response;


public interface UserService {
    Response save(User user) throws UserNameExistsException;
}
