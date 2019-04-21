package com.identity.auth.business.services;

import com.identity.auth.business.resource.User;

import javax.ws.rs.core.Response;


public interface UserService {
    Response save(User user);
}
