package com.identity.auth.business.resource;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.identity.auth.business.resource.impl.DefaultUser;

@JsonDeserialize(as = DefaultUser.class)
public interface User{

    Long getId();

    String getUserName();

    char[] getPassword();

    String getFirstName();

    String getLastName();

    String getEmail();

}
