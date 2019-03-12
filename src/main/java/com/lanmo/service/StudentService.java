package com.lanmo.service;

import com.lanmo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

@Service
public class StudentService {

//    @Qualifier("studentDao")
//    @Autowired(required = false)
//    @Resource(name="studentDao")
    @Inject
    private StudentDao studentDao;

    public void print(){
        System.out.println(studentDao);
    }

    @Override
    public String toString() {
        return "StudentService{" +
                "studentDao=" + studentDao +
                '}';
    }
}
