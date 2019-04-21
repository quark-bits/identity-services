package com.identity.auth.persistence.respositories;

import com.identity.auth.persistence.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,String>{
    Optional<UserEntity> findByUserName(String userName);
}
