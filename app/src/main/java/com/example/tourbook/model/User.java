package com.example.tourbook.modle;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class User implements Serializable {
    private int id;
    private String fullName;
    private String email;
    private String username;
    private String password;
    private String gender;
    private String birthday;

    public User(int id, String fullName, String email, String username, String password, String gender, String birthday){
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
    }
}
