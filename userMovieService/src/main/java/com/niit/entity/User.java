package com.niit.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * User Entity
 */
@Document
public class User {
    @Id
    private String email;
    private String userName;
    private String mobile;
    private String password;
    private List<Movie> movieList;

    /**
     * @return User entity in String format.
     */
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", movieList=" + movieList +
                '}';
    }

    //Getter and Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    public User(String email, String userName, String mobile, String password, List<Movie> movieList) {
        this.email = email;
        this.userName = userName;
        this.mobile = mobile;
        this.password = password;
        this.movieList = movieList;
    }
}