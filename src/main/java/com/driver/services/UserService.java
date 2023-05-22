package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(String username, String password){
         User user = new User();

         user.setUsername(username);
         user.setPassword(password);

         user.setFirstName("test");
         user.setLastName("test");

         userRepository.save(user);
    }

    public void deleteUser(int userId){

        userRepository.deleteById(userId);
    }

    public void updateUser(Integer id, String password){

        Optional<User> optionalUser = userRepository.findById(id);

        User user = optionalUser.get();

        user.setPassword(password);

        userRepository.save(user);
    }
}
