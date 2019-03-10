package com.lanmo.config;


import com.lanmo.bean.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Teacher.class})
public class TeacherTest {

    @Autowired
    private Teacher teacher;

    @Test
    public void testTeacher(){
        System.out.println(teacher);
    }

}
