package com.identity.auth.persistence.respositories;

import com.identity.auth.persistence.entities.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void test_User_Is_Saved(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("jack");
        userEntity.setPassword("jack@Password");
        userEntity.setFirstName("jack_First");
        userEntity.setLastName("jack_Last");
        userEntity.setEmail("jack@nomail.com");

        userRepository.save(userEntity);

        Optional<UserEntity> savedEntity = userRepository.findByUserName(userEntity.getUserName());
        if (savedEntity.isPresent()) {
            assertTrue(savedEntity.get().getUserName().equals(userEntity.getUserName()));
        }
        else{
            assertTrue(Boolean.FALSE);
        }
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void test_UserName_Already_Exists_Error(){
        UserEntity user1 = new UserEntity();
        user1.setUserName("jack");
        user1.setPassword("jack@Password");
        user1.setFirstName("jack_First");
        user1.setLastName("jack_Last");
        user1.setEmail("jack@nomail.com");

        userRepository.save(user1);

        UserEntity user2 = new UserEntity();
        user2.setUserName("jack");
        user2.setPassword("jack@Password");
        user2.setFirstName("jack_First");
        user2.setLastName("jack_Last");
        user2.setEmail("jack@nomail.com");

        // Try to save same values for the second time.
        userRepository.save(user2);
    }


    @Test(expected = DataIntegrityViolationException.class)
    public void test_Email_Already_Exists_Error(){
        UserEntity user1 = new UserEntity();
        user1.setUserName("jack");
        user1.setPassword("jack@Password");
        user1.setFirstName("jack_First");
        user1.setLastName("jack_Last");
        user1.setEmail("jack@nomail.com");

        userRepository.save(user1);

        UserEntity user2 = new UserEntity();
        user2.setUserName("newjack");
        user2.setPassword("jack@Password");
        user2.setFirstName("jack_First");
        user2.setLastName("jack_Last");
        user2.setEmail("jack@nomail.com");

        // Try to save same values for the second time.
        userRepository.save(user2);
    }

}