import com.lanmo.bean.Cat;
import com.lanmo.ext.ExtConfig;
import com.lanmo.tx.TxConfig;
import com.lanmo.tx.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author NJ
 * @date 2019/3/13 17:54
 */
public class IOCTest_Ext {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext acp = new AnnotationConfigApplicationContext(ExtConfig.class);

        //发布事件
        acp.publishEvent(new ApplicationEvent(new String("我发布事件")) {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });

        acp.close();
    }
}
