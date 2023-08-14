package com.aditya.service;

import com.aditya.entity.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtSecurityTokenGen implements SecurityTokenGen{
    @Override
    public Map<String, String> generateToken(User user) {
        String jsonWebToken = null;

        JwtBuilder jwtBuilder = Jwts.builder();
        jsonWebToken = jwtBuilder.setSubject(user.getUserName()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"secret").compact();

        Map<String,String> tokenMap = new HashMap<String,String>();
        tokenMap.put("token",jsonWebToken);
        tokenMap.put("message","User Successfully loggedIn");

        return tokenMap;
    }
}
