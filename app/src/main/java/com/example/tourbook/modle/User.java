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
}
