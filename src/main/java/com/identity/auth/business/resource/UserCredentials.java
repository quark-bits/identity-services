package com.identity.auth.business.resource;

import lombok.Data;

@Data
public class UserCredentials implements Identifiable {
    private String userName;
    private char[] password;
    private Long id;

    @Override
    public int getObjectType() {
        return ResourceType.USER.getType();
    }
}
