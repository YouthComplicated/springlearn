package com.lanmo.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 事物
 *
 * 环境搭建:
 *  1、数据源、数据库驱动、spring-jdbc
 *  2、配置数据源、JdbcTemplate(Spring提供简化操作数据)
 *  3、方法加上@Transactional
 *  4、配置类上开启基于注解的事物管理器功能 @EnableTransactionManagement
 *  5、配置事物管理器管理事物 No qualifying bean of type 'org.springframework.transaction.PlatformTransactionManager' available
 *      PlatformTransactionManager
 *      利用TransactionManagementConfigurationSelector给容器导入两个组件:
 *           AutoProxyRegistrar
 *           ProxyTransactionManagementConfiguration
 *     AutoProxyRegistrar:
 *          InfrastructureAdvisorAutoProxyCreator:
 *              后置处理器机制，在对象创建之后，包装对象，返回一个代理对象(增强器)，代理对象执行方法利用拦截器进行
 *     ProxyTransactionManagementConfiguration：
 *              1、给容器注入增强器 AnnotationTransactionAttributeSource
 *              2、事务拦截器：TransactionInterceptor 保存事务属性信息，事务拦截器
 *                  MethodInterceptor
 *                  目标方法执行的时候执行拦截器链
 *                  事务拦截器：
 *                      1、先获取事务的相关属性
 *                      2、在获取PlatformTransactionManager,如果事先没有指定类型，会默认从容器中找到
 *                      3、执行目标方法
 *                      4、如果异常，利用事务管理器进行回滚操作
 * @author NJ
 * @date 2019/3/13 15:13
 */
@EnableTransactionManagement
@Configuration
@ComponentScan("com.lanmo.tx")
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/dev?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT");
//        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");

        return comboPooledDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //spring对@Configuration会特殊处理，多次调用会从容器找组件
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        return new DataSourceTransactionManager(dataSource());
    }



}
