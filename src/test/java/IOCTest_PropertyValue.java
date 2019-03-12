import com.lanmo.config.MainConfigOfPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author NJ
 * @date 2019/3/11 16:27
 */
public class IOCTest_PropertyValue {
    AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);


    @Test
    public void test01(){
        printBeans(acp);
        Object person = acp.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = acp.getEnvironment();
        System.out.println(environment.getProperty("job"));
        System.out.println(environment.getProperty("name"));


    }

    public void printBeans(AnnotationConfigApplicationContext acp){
        String[] beanDefinitionNames = acp.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
    }

}
