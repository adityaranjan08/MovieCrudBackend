package com.aditya.controller;

import com.aditya.entity.User;
import com.aditya.exception.UserNotFoundException;
import com.aditya.service.JwtSecurityTokenGen;
import com.aditya.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class UserRestController {

    @Autowired
    UserService userService;
    @Autowired
    JwtSecurityTokenGen jwtSecurityTokenGen;

    @PostMapping("/login")
//    @CrossOrigin(origins = "http://localhost:4200")
    @HystrixCommand(fallbackMethod = "fallbackLogin",commandKey = "loginkey",groupKey = "login")
    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
    public ResponseEntity<?> credentialCheck(@RequestBody User user) throws InterruptedException {
        Thread.sleep(500);
        ResponseEntity responseEntity = null;
        try{
            User user1 = userService.findByEmailAndPasswordCheck(user.getEmail(), user.getPassword());

            if(user1.getEmail().equals(user.getEmail())){

                Map<String,String> tokenMap = jwtSecurityTokenGen.generateToken(user1);
                responseEntity = new ResponseEntity<>(tokenMap,HttpStatus.OK);
            }else{
                responseEntity = new ResponseEntity<>("Invalid User",HttpStatus.NOT_FOUND);
            }


        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return responseEntity;
    }

    public ResponseEntity<?> fallbackLogin(@RequestBody User user){
        String msg = "login failed";
        return new ResponseEntity<>(msg,HttpStatus.GATEWAY_TIMEOUT);
    }

    @PostMapping("/register")
    public ResponseEntity<?> addUsers(@RequestBody User user) {
        return new ResponseEntity<User>(userService.registerUser(user),HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

}
