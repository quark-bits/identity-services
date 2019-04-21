package com.identity.auth.business.resource.impl;

import com.identity.auth.business.resource.User;
import lombok.Data;

@Data
public class DefaultUser implements User {
    private Long id;
    private String userName;
    private char[] password;
    private String firstName;
    private String lastName;
    private String email;
}
