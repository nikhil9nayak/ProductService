package com.productservice.productservice.inheritancerelations.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // It will only create st_user table, It won't create table for mentor, student and ta even if we use @Entity over there
@Entity(name = "st_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id will generate auto increment value
    private Long id;
    private String name;
    private String email;
}
