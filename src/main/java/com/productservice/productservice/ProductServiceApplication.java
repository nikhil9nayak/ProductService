package com.productservice.productservice;


import com.productservice.productservice.inheritancerelations.singletable.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private MentorRepository mentorRepository;
    private UserRepository userRepository;
    private StudentRepository studentRepository;

    public ProductServiceApplication(@Qualifier("st_mentorrepo") MentorRepository mentorRepository,
                                     @Qualifier("st_userrepo") UserRepository userRepository,
                                     @Qualifier("st_studentrepo") StudentRepository studentRepository){
        this.mentorRepository = mentorRepository;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//    public ProductServiceApplication(@Qualifier("tpc_mentorrepository")
//                                     MentorRepository mentorRepository,
//                                     StudentRepository studentRepository,
//                                     UserRepository userRepository) {
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    //Below are the code for insert data in to resp. table
    @Override
    public void run(String... args) throws Exception {

//        //tcp_mentor
//        Mentor mentor = new Mentor();
//        mentor.setName("Nikhil");
//        mentor.setEmail("nikhil9nayak@gmail.com");
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//        //tcp_student
//        Student student = new Student();
//        student.setEmail("nikhil9nayak@gmail.com");
//        student.setName("Nikhil");
//        student.setPsp(80.0);
//        studentRepository.save(student);
//
//        //tsp_user
//        User user = new User();
//        user.setEmail("nikhil9nayak@gmail.com");
//        user.setName("Nikhil");
//        userRepository.save(user);
//
//        //Get all the users
//        List<User> users = userRepository.findAll();
//        for(User user1 : users){
//            System.out.println(user1.toString());
//        }

        User user = new User();
        user.setName("Nikhil");
        user.setEmail("nikhil9nayak@gmail.com");
        userRepository.save(user);

        Mentor mentor = new Mentor();
        mentor.setName("Nayak");
        mentor.setEmail("xyz@gmail.com");
        mentor.setAvgRating(4.7);
        mentorRepository.save(mentor);

        Student student = new Student();
        student.setName("Kumar");
        student.setEmail("abc@gmail.com");
        student.setPsp(99.0);
        studentRepository.save(student);
    }
}
