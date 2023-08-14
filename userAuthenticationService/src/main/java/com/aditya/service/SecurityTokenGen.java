package com.aditya.service;

import com.aditya.entity.User;

import java.util.Map;

public interface SecurityTokenGen {
    Map<String,String> generateToken(User user);
}
