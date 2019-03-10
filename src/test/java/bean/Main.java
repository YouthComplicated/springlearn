package bean;

import com.lanmo.bean.Student;
import com.lanmo.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        /**
         * 基于xml
         */
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        Student student = (Student) applicationContext.getBean("student");
//        System.out.println(student);

        /**
         * 基于注解
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Student  student = applicationContext.getBean(Student.class);
        System.out.println(student);




    }
}
