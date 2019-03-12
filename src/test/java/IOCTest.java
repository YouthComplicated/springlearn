import com.lanmo.bean.Animal;
import com.lanmo.bean.Person;
import com.lanmo.bean.Student;
import com.lanmo.config.MainConfig;
import com.lanmo.config.MainConfig2;
import com.sun.media.sound.SoftTuning;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

public class IOCTest {


    AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(MainConfig2.class);


    @Test
    public void test01(){
        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanNames = acp.getBeanDefinitionNames();
        for(String name : beanNames){
            System.out.println(name);
        }
        System.out.println(acp.getBean("student"));
        System.out.println(acp.getBean("student"));
//        System.out.println(Arrays.toString(beanNames));
    }


    @Test
    public void test02(){
        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(MainConfig2.class);
        System.out.println("IOC容器创建完成.....");

        String[] beanNames = acp.getBeanDefinitionNames();
        for(String name : beanNames){
            System.out.println(name);
        }

        Object obj1 =  acp.getBean("student");
//        Object obj2 =  acp.getBean("student");
//        System.out.println(obj1 == obj2);

    }

    @Test
    public void test03(){
        String [] types = acp.getBeanNamesForType(Student.class);

        ConfigurableEnvironment ev = acp.getEnvironment();
        String property = ev.getProperty("os.name");
        System.out.println(property);
        for (String type : types){
            System.out.println(type);
        }

        Map<String, Student> studentMap = acp.getBeansOfType(Student.class);
        System.out.println(studentMap);
    }

    @Test
    public void testImport(){
        printBeans(acp);
//        Object animal = acp.getBean(Animal.class);
//        System.out.println(animal);

        //获取是getObject 创建的对象
        Object personFactoryBean = acp.getBean("personFactoryBean");
        Object personFactoryBean1 = acp.getBean("personFactoryBean");
        System.out.println(personFactoryBean == personFactoryBean1);
        System.out.println("personFactoryBean:"+personFactoryBean);
        System.out.println("personFactory的类型："+personFactoryBean.getClass());
        Object personFactoryBean2 = acp.getBean("&personFactoryBean");
        System.out.println(personFactoryBean2);


    }

    public void printBeans(AnnotationConfigApplicationContext acp){
        String[] beanDefinitionNames = acp.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }

}
