package com.identity.auth.business.resource;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserCredentials implements Identifiable {
    @Size(min = 8, max = 30)
    private String userName;

    @Size(min = 8, max = 30)
    private char[] password;

    private Long id;

    @Override
    public int getObjectType() {
        return ResourceType.USER.getType();
    }
}
