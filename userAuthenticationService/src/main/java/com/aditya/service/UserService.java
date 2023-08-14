package com.aditya.service;

import com.aditya.entity.User;
import com.aditya.exception.UserNotFoundException;
import com.aditya.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User registerUser(User user) {
      return userRepository.save(user);
  }

  public User findByEmailAndPasswordCheck(String email,String password) throws UserNotFoundException {
      User user = userRepository.findByEmailAndPassword(email, password);
      if(user==null){
          throw new UserNotFoundException();
      }
      return user;
  }

  public List<User> getAllUsers(){
      return userRepository.findAll();
  }

}
