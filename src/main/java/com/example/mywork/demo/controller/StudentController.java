package com.example.mywork.demo.controller;

import com.example.mywork.demo.pojos.Student;
import com.example.mywork.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    //@Autowired
    public StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping(value = "/student")
    public List<Student> getAll(){
        System.out.println("Inside getAll method (Controller)");
        return studentService.retriveAll();
    }

    @GetMapping(value = "/student/{id}")
    public Optional<Student> getOnebyId(@PathVariable long id){
        System.out.println("Inside getOnebyId method (Controller)");
        return studentService.retriveOne(id);
    }

    @PostMapping(value = "/student")
    public void addStudent(@Valid @RequestBody Student student){
        System.out.println("Inside addStudent method (Controller)");
        studentService.add(student);
    }

    @DeleteMapping(value = "/student/{id}")
    public void deleteById(@PathVariable long id){
        System.out.println("Inside deleteById method (Controller)");
        studentService.deleteById(id);
    }

    @PutMapping(value = "/student")
    public void updateStudent(@RequestBody Student student){
        studentService.update(student);
    }
    @GetMapping(value = "/student/coursename/{course}")
    public List<Student> getStudentByCourse(@PathVariable String course){
        return studentService.getByCourse(course);
    }
    @GetMapping(value = "/student/name/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        System.out.println("Inside getStudentByName method (Controller)");
        return studentService.getByName(name);
    }
}
