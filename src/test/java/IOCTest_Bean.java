import com.lanmo.bean.Student;
import com.lanmo.config.MainConfig;
import com.lanmo.config.MainConfigOfBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfigOfBean.class)
public class IOCTest_Bean {

    @Autowired
    private Student student;

    @Test
    public void Test01(){
        System.out.println(111);
        System.out.println(student);
    }
}
