package com.spring.boot.demo.controller;


import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.boot.demo.exception.ResourceNotFoundException;
import com.spring.boot.demo.model.User;
import com.spring.boot.demo.model.repository.UserRepository;


@Controller
public class UserController {


    @Autowired
    private UserRepository userRepository;

 
   
    public List<User> getAllUsers() {
         return userRepository.findAll();
    }

    
    public User getUserById(Long userId) throws ResourceNotFoundException {
         
    	User user = userRepository.findById(userId)
    			.orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
        return user;
    }

    
    public User createUser(User user) {
        return userRepository.save(user);
    }

   
    public User updateUser(
      Long userId,
      User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userId)
          .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
  
        //user.setEmailId(userDetails.getEmailId());
        user.setLastName(userDetails.getLastName());
        user.setFirstName(userDetails.getFirstName());
        user.setLastModifiedDate(new Date());
        final User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    
    public void deleteUser(
         Long userId) throws ResourceNotFoundException {
         User user = userRepository.findById(userId)
          .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        userRepository.delete(user);
    }
    
    public List<User> findUsersByLastName(String lastName) {
        return userRepository.findUsersByLastName(lastName);
   }	
}
