import com.lanmo.config.TeacherConfigOfRunWith;
import com.lanmo.mybean.Teacher;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.SystemErrRule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TeacherConfigOfRunWith.class})
public class TeacherConfigRunWithTest {


//    @Rule // 过去写法
//    private final StandardOutputStreamLog log=new StandardOutputStreamLog();

    //正确输出
    @Rule
    public  final SystemOutRule log = new SystemOutRule().enableLog();

    //错误输出
    @Rule
    public  final SystemErrRule errrule=new SystemErrRule();

    @Autowired
    private Teacher teacher;

    @Test
    public void testTeacher(){
        System.out.println(">>>>>TeacherConfigRunWithTest:"+teacher);
    }

    /**
     * 注意 windows(CRLF-->\r\n)  换行与unix,os不一样(LF-->\n)
     */
    @Test
    public void teacherIsNull(){
//        Assert.assertNotNull(log.getLog(), teacher);
//        Assert.assertNotEquals(2,log.getLog());

        teacher.say();
        Assert.assertEquals("hello2\r\n", log.getLog());

    }


    @Test
    public void test01(){

    }
}
