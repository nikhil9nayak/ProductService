package com.productservice.productservice.inheritancerelations.tableperclass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tpc_mentorrepository") // Below is the class used to interact with resp Tables
public interface MentorRepository extends JpaRepository<Mentor, Long> { // this mentorRepository is used to interact with mentor table
    @Override
    Mentor save(Mentor mentor); // this is the method to insert data into table, and the data has been inserted from main()
}
