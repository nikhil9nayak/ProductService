package com.productservice.productservice.inheritancerelations.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Getter
@Setter
@ToString
@Entity(name = "tpc_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // Mentioning which type of inheritance whether it is TablePerClass or SingleTable or JOinTable
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Id will generate auto increment value
    private Long id;
    private String name;
    private String email;
}
