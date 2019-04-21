package com.identity.auth.business.services.impl;

import com.identity.auth.AuthAppErrorCode;
import com.identity.auth.business.resource.User;
import com.identity.auth.business.managers.UserManager;
import com.identity.auth.business.services.UserService;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Component("userService")
@Path("/v1/user")
public class DefaultUserService implements UserService {

    private final UserManager userManager;

    public DefaultUserService(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(User user) {
        Optional<User> savedUser = userManager.createUser(user);
        if(savedUser.isPresent()){
            return Response.status(201, savedUser.get().toString()).build();
        }
        return Response.status(422,"Error_Message").build();
    }
}
