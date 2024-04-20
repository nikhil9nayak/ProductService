package com.productservice.productservice;


import com.productservice.productservice.inheritancerelations.mappedsuperclass.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;
    public ProductServiceApplication(@Qualifier("ms_mentorrepository")
                                     MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    //Below are the code for insert data in to resp. table
    @Override
    public void run(String... args) throws Exception {

        //ms_mentor
        Mentor mentor = new Mentor();
        mentor.setName("Nikhil");
        mentor.setEmail("nikhil9nayak@gmail.com");
        mentor.setAvgRating(4.7);
        mentorRepository.save(mentor);

    }
}
