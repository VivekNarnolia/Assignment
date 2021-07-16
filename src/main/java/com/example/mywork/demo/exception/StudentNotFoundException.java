package com.example.mywork.demo.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String msg){
        super(msg);
    }
}
