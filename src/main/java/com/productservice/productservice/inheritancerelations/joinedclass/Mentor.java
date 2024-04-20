package com.productservice.productservice.inheritancerelations.joinedclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_mentor")
@PrimaryKeyJoinColumn(name = "user_id") // we're indicating that the user_id column in the Mentor table should serve as the primary key column, and it should be associated with the primary key column in the superclass table (User). In the absence of @PrimaryKeyJoinColumn, JPA will automatically use the primary key column from the superclass (User) as the foreign key column in the subclass (Mentor).
public class Mentor extends User {
    private double avgRating;
}
