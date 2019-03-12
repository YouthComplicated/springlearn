package com.lanmo.controller;

import com.lanmo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    public void print(){
        System.out.println(studentService);
    }
}
