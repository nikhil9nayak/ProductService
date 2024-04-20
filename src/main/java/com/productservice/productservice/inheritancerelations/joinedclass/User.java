package com.productservice.productservice.inheritancerelations.joinedclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "j_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id will generate auto increment value
    private Long id;
    private String name;
    private String email;
}
