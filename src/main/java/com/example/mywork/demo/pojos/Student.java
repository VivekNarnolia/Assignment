package com.example.mywork.demo.pojos;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;

@Document("student")
public class Student {
    @Id
    public long studentId;
    @Size(min = 4,message = "Minimum 4 character is required")
    public String name;
    public String course;
    public Student(){

    }

    public Student(long studentId, String name, String course) {
        this.studentId = studentId;
        this.name = name;
        this.course = course;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse(String course) {
        return course;
    }
}
