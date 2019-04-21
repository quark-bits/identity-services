package com.identity.auth.business.resource.impl;

import com.identity.auth.business.resource.ResourceType;
import com.identity.auth.business.resource.User;
import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class DefaultUser implements User {
    private Long id;

    @Size(min = 8, max = 30)
    private String userName;

    @Size(min = 8, max = 30)
    private char[] password;

    @Size(min = 8, max = 30)
    private String firstName;

    @Size(min = 8, max = 30)
    private String lastName;

    @Size(min = 8, max = 30)
    private String email;

    @Override
    public int getObjectType() {
        return ResourceType.USER.getType();
    }
}
