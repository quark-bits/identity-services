package com.identity.auth.business.resource;

import lombok.Data;

@Data
public class UserCredentials {
    private String userName;
    private char[] password;
}
