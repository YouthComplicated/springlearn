import com.lanmo.aop.Calc;
import com.lanmo.config.MainConfigOfAOP;
import com.lanmo.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author NJ
 * @date 2019/3/12 16:07
 */
public class IOCTest_AOP {

    @Test
    public void test01(){

        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);

        //不要自己创建被切入的对象

        Calc cal = acp.getBean(Calc.class);
        cal.div(1,3);
        cal.div(1,0);
        String[] nameForType = acp.getBeanNamesForType(DataSource.class);
        for(String name : nameForType){
            System.out.println(name);
        }

    }
}
