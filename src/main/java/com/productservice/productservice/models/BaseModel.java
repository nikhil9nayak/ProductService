package com.productservice.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass //We are telling Hibernate, not to create any table of this parent class, and pass on the attributes of this class to its child class
public class BaseModel { // BaseModel will contain the common attributes of Product and Category class
    @Id  // We are marking "id" as Primary Key
    @GeneratedValue(generator = "uuidgenerator") // defining generator value
    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2") // acc to the generator value it will auto generate the UUID when we insert data in to table
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false) // defining what column name should be there in DB and types
    private UUID id; // if we use UUID then the probability of duplicate is less, Above 3 @ are used to auto generate UUID
}


/*
UUID:
=====

id = {Current time + Mac id + Ip Address + RAM + Internet Speed + UserId + HDD +...}

Above id is called UUID.
UUID is a 128-bit identifier that is globally unique across space and time, meaning it is highly impossible for two UUIDs to be the same.

If we use UUID as String then we need 32 Byte of storage.
If we use UUID as Binary then we need 16 Byte of storage.

As we can see that String is taking 2X amount of storage than binary.

So in code we will use UUID data type instead of Long or String.
Bcoz long doesn't work well in distributed system and String takes more storage.

 */