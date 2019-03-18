import com.lanmo.aop.mixmethod.MixConifg;
import com.lanmo.aop.mixmethod.Sports;
import com.lanmo.aop.mixmethod.Student;
import com.lanmo.aop.mixmethod.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MixConifg.class)
public class IOCTest_MixMethod {

    @Autowired
    private Student student;

    @Autowired
    private Teacher teacher;

    @Test
    public void test01(){
        student.showIdentity();
        ((Sports) student).doSomething();
        teacher.toShow();
        Sports sports = (Sports) teacher;
        ((Sports) teacher).doSomething();
    }
}
