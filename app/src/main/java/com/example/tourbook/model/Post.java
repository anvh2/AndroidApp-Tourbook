package com.example.tourbook.modle;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Post implements Serializable {
    private int id;
    private String title;
    private String description;
    private String content;
    private String mode;
    private String place;
}
