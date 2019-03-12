import com.lanmo.config.MainConfig;
import com.lanmo.config.MainConfigOfLifeCycle;
import com.lanmo.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @author NJ
 * @date 2019/3/12 16:07
 */
public class IOCTest_Profile {


    //1、使用命令动态参数：在虚拟机参数:-Dspring.profiles.active=dev
    //2、代码实现方式
    @Test
    public void test01(){

        //AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);

        //1、创建一个ApplicationContext
        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext();
        //2、设置需要激活的环境
        acp.getEnvironment().setActiveProfiles("test");
        //3、注册主配置类
        acp.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        acp.refresh();

        System.out.println(acp.getBean("student"));

        String[] nameForType = acp.getBeanNamesForType(DataSource.class);
        for(String name : nameForType){
            System.out.println(name);
        }

    }
}
