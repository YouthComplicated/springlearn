package com.lanmo.config;

import com.lanmo.bean.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *
 * spring根据当期环境，动态的激活和切换一系列组件功能
 *
 * 开发环境、测试环境、生产环境
 * 数据源切换
 * 不同机器微服务
 *
 * @Profile: 指定组件在那个环境情况下才能被注册到容器中，不指定，任何环境下都能注册改组件
 *
 * 1)加了环境标识的bean，只有这个环境被激活才能注册到容器中。
 *
 * 2)在配置类上，只有是指定环境的时候，整个配置类所有配置才能开始生效
 *
 * 3)没有标注环境标识的bean，在任何环境下都加载
 *
 * @author NJ
 * @date 2019/3/12 15:38
 */
@Profile("pro")
@Configuration
@PropertySource("classpath:/jdbc.properties")
public class MainConfigOfProfile implements EmbeddedValueResolverAware{

    private StringValueResolver resolver;

    private String driveClass;


    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        driveClass = resolver.resolveStringValue("${db.driverClass}");
    }

//    @Profile("test")
    @Bean
    public Student student(){
        return  new Student();
    }


    @Value("${db.user}")
    private String userName;

    @Bean("devDataSource")
//    @Profile("default")
    @Profile("dev")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(userName);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        return comboPooledDataSource;
    }

    @Bean("testDataSource")
    @Profile("test")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(userName);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setDriverClass(driveClass);
        return comboPooledDataSource;
    }

    @Bean("proDataSource")
    @Profile("pro")
    public DataSource dataSourcePro(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser(userName);
        comboPooledDataSource.setPassword(pwd);
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/pro");
        comboPooledDataSource.setDriverClass(driveClass);
        return comboPooledDataSource;
    }






}
