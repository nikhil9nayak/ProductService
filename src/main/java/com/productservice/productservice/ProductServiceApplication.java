package com.productservice.productservice;


import com.productservice.productservice.inheritancerelations.singletable.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.PriceRepository;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ReactiveAdapterRegistry;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

//    private MentorRepository mentorRepository;
//    private UserRepository userRepository;
//    private StudentRepository studentRepository;
//
//    public ProductServiceApplication(@Qualifier("st_mentorrepo") MentorRepository mentorRepository,
//                                     @Qualifier("st_userrepo") UserRepository userRepository,
//                                     @Qualifier("st_studentrepo") StudentRepository studentRepository){
//        this.mentorRepository = mentorRepository;
//        this.userRepository = userRepository;
//        this.studentRepository = studentRepository;
//    }

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

//        User user = new User();
//        user.setName("Nikhil");
//        user.setEmail("nikhil9nayak@gmail.com");
//        userRepository.save(user);
//
//        Mentor mentor = new Mentor();
//        mentor.setName("Nayak");
//        mentor.setEmail("xyz@gmail.com");
//        mentor.setAvgRating(4.7);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Kumar");
//        student.setEmail("abc@gmail.com");
//        student.setPsp(99.0);
//        studentRepository.save(student);

//        Category category = new Category();
//        category.setName("Apple Devices");
//
//        Category savedCategory = categoryRepository.save(category);

//        Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString("2c137886-b2db-42ab-b00e-3d48fc67b9a4"));
//
//        if(optionalCategory.isEmpty()){
//            throw new Exception("Category is Null");
//        }
//
//        Category category = optionalCategory.get();
//        Product product = new Product();
//        product.setTitle("iphone 15 pro");
//        product.setDescription("Best iphone");
//        product.setCategory(category.get());
//
//        Product savedProduct = productRepository.save(product);

        //find all the products with category = Apple Devices
//        List<Product> products = category.getProducts();
//
//        for(Product product : products){
//            System.out.println(product.getTitle());
//        }

//        Price price = new Price();
//        price.setCurrency("INR");
//        price.setValue(10000);
//
//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Product product = new Product();
//        product.setTitle("iphone 15 pro");
//        product.setDescription("Best iphone");
//        product.setImage("IMG");
//        product.setCategory(savedCategory);
//        product.setPrice(price);
//        Product savedProduct = productRepository.save(product);

//        productRepository.deleteById(UUID.fromString("a8de0555-f594-4e5c-b8f9-50e3b4afc84e"));

//        List<Product> products = productRepository.findAllByPrice_ValueBetween(100, 200);
    }
}
