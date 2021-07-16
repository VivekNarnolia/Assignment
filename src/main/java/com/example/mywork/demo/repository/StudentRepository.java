package com.example.mywork.demo.repository;

import com.example.mywork.demo.pojos.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,Long> {

    List<Student> findByCourse(String course);

    List<Student> findByName(String name);
}
