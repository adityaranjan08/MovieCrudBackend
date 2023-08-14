package com.aditya.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class User {

    @Id
    String email;
    String userName;
    String password;
    String mobile;

}
