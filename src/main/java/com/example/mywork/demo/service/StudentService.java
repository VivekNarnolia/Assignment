package com.example.mywork.demo.service;

import com.example.mywork.demo.exception.StudentNotFoundException;
import com.example.mywork.demo.pojos.Student;
import com.example.mywork.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;

    public Optional<Student> retriveOne(long id){
        Optional<Student> savedStudent=studentRepository.findById(id);
        if(!savedStudent.isPresent()){
            throw new StudentNotFoundException("Student not present in database");
        }
        return savedStudent;
    }
    public List<Student> retriveAll(){
        System.out.println("Inside retriveAll method (Service)");
        List<Student> savedStudent=studentRepository.findAll();
//        if(!savedStudent.isEmpty()){
//            throw new StudentNotFoundException("Database is empty");
//        }
        return savedStudent;
    }
    public Student add(Student student){
        Student newStudent=studentRepository.insert(student);
        return newStudent;

    }
    public String deleteById(long id){
        System.out.println("Inside deleteById method (Service)");

        Optional<Student> savedStudent=studentRepository.findById(id);
        if(!savedStudent.isPresent()){
            throw new StudentNotFoundException("Student not present in database");
        }
        studentRepository.deleteById(id);
        return "Student with id: "+savedStudent.get().getStudentId()+ "and Name: "+savedStudent.get().getName()+ "deleted";
    }
    public Student update(Student student){
        Optional<Student> savedStudent=studentRepository.findById(student.getStudentId());
        savedStudent.get().setStudentId(student.getStudentId());
        savedStudent.get().setName(student.getName());
        savedStudent.get().setCourse(student.getCourse());
        return studentRepository.save(student);
    }

    public List<Student> getByCourse(String course) {
        return studentRepository.findByCourse(course);

    }
    public List<Student> getByName(String name) {
        return studentRepository.findByName(name);

    }
}
