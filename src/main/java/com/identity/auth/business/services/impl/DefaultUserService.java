package com.identity.auth.business.services.impl;

import com.identity.auth.business.managers.UserManager;
import com.identity.auth.business.resource.User;
import com.identity.auth.business.services.UserService;
import com.identity.auth.exception.user.UserExistsException;
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
        Optional<User> savedUser = null;
        try {
            savedUser = userManager.createUser(user);
        } catch (UserExistsException e) {
            return Response
                    .status(422)
                    .entity(new UserExistsException(e.getDescription(),true))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        catch (Exception e){
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getCause().toString())
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
        return Response
                .status(Response.Status.CREATED.getStatusCode())
                .entity(savedUser.get())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
