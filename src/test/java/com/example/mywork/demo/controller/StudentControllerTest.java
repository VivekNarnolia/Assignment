package com.example.mywork.demo.controller;

import com.example.mywork.demo.pojos.Student;
import com.example.mywork.demo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//Class level annotation
@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    //The class we want to test in junit
    @InjectMocks
    private StudentController studentController;

    //To get dummy objects of Service layer
    //The class we don't want to test
    //The request flow will not go to database
    @Mock
    private StudentService studentService;

    @Test
    public void getAllTest(){

        //Give
        List<Student> students=new ArrayList<Student>();
        students.add(new Student(1,"Thanos","Hadoop"));
        students.add(new Student(2,"Tony Stark","Sqoop"));
        //When   //Then
        when(studentService.retriveAll()).thenReturn(students);
        //Assert Test
        List<Student> newStudent=studentController.getAll();
        assertEquals(2,newStudent.size());
    }
    @Test
    public void getByNameTest(){
        String newName="The Rock";
        //Give
        List<Student> students=new ArrayList<Student>();
        students.add(new Student(1,"Hulk","Hadoop"));

        //When   //Then
        when(studentService.getByName(newName)).thenReturn(students);
        //Assert Test
        List<Student> newStudent=studentController.getStudentByName(newName);
        assertEquals(1,newStudent.size());

    }
    @Test
    public void addStudentTest(){
        Student students=new Student(10,"Thor","Big Data");
        when(studentService.add(students)).thenReturn(students);
        //assertEquals(students,studentService.add(students));
        assertEquals(students,studentService.add(students));
    }
    @Test
    public void deleteStudentTest(){
        Student students=new Student(10,"Thor","Big Data");
        studentService.deleteById(students.getStudentId());
        verify(studentService,times(1)).deleteById(students.getStudentId());
    }

}
