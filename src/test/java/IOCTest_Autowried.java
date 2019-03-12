import com.lanmo.bean.Bear;
import com.lanmo.bean.Cat;
import com.lanmo.config.MainConfigOfAutowired;
import com.lanmo.dao.StudentDao;
import com.lanmo.service.StudentService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author NJ
 * @date 2019/3/11 17:31
 */
public class IOCTest_Autowried {
    @Test
    public void test01(){
        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

        StudentService bean = acp.getBean(StudentService.class);
        System.out.println(bean.toString());
        bean.print();

//        StudentDao studentDao = acp.getBean(StudentDao.class);
//        System.out.println(studentDao);

        Bear bear = acp.getBean(Bear.class);
        System.out.println("bear:"+bear);

        Cat cat = acp.getBean(Cat.class);
        System.out.println(cat);


        acp.close();
    }
}
