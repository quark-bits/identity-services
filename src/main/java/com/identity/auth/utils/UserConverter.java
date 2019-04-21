package com.identity.auth.utils;

import com.identity.auth.business.resource.User;
import com.identity.auth.business.resource.impl.DefaultUser;
import com.identity.auth.persistence.entities.UserEntity;

public class UserConverter {

    public static UserEntity toUserEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(EncryptionUtils.encrypt(new String(user.getPassword())));    // Store Encrypted Password
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        return userEntity;
    }

    public static User toUser(UserEntity userEntity){
        DefaultUser user = new DefaultUser();
        user.setId(userEntity.getId());
        user.setUserName(userEntity.getUserName());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        return user;
    }

}
