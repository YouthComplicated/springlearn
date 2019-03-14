import com.lanmo.tx.TxConfig;
import com.lanmo.tx.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author NJ
 * @date 2019/3/13 15:31
 */
public class IOCTest_tx {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = acp.getBean(UserService.class);
        userService.insertUser();
    }


    @Test
    public void test02(){
        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(TxConfig.class);
        UserService userService = acp.getBean(UserService.class);
        userService.insertUser();
    }
}
