package com.identity.auth.config;

import com.identity.auth.business.services.impl.DefaultUserService;
import com.identity.auth.business.services.impl.PasswordAuthenticationService;
import com.identity.auth.exception.DataIntegrityViolationExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(DefaultUserService.class);
        register(PasswordAuthenticationService.class);
        register(DataIntegrityViolationExceptionMapper.class);
    }
}
