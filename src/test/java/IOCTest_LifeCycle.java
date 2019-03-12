import com.lanmo.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author NJ
 * @date 2019/3/11 14:39
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01(){
        //创建IOC容器
        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建完成");

        Object cat = acp.getBean("cat");
        System.out.println(cat);

        acp.close();
        System.out.println("容器关闭");

//        Object cat = acp.getBean("cat");
//        System.out.println(cat);

    }



}
