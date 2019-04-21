package com.identity.auth.business.managers.impl;

import com.identity.auth.business.resource.User;
import com.identity.auth.business.managers.UserManager;
import com.identity.auth.business.resource.UserCredentials;
import com.identity.auth.persistence.entities.UserEntity;
import com.identity.auth.persistence.respositories.UserRepository;
import com.identity.auth.utils.UserConverter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("DefaultUserManager")
public class DefaultUserManager implements UserManager {

    private UserRepository userRepository;

    public DefaultUserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> createUser(User user) {
        UserEntity userEntity = UserConverter.toUserEntity(user);
        UserEntity createdUserEntity = userRepository.save(userEntity);
        return Optional.of(UserConverter.toUser(createdUserEntity));
    }

    public Optional<User> getUser(String username){
        Optional<UserEntity> userEntity = userRepository.findByUserName(username);
        if(userEntity.isPresent()){
            return Optional.of(UserConverter.toUser(userEntity.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserCredentials> getUserCredentials(User user) {
        Optional<UserEntity> userEntity = userRepository.findByUserName(user.getUserName());
        if(userEntity.isPresent()){
            UserCredentials userCredentials = new UserCredentials();
            userCredentials.setUserName(userEntity.get().getUserName());
            userCredentials.setPassword(userEntity.get().getPassword().toCharArray());
            return Optional.of(userCredentials);
        }
        return Optional.empty();
    }

}
