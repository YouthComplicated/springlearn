package com.lanmo.config;

import com.lanmo.bean.Student;
import org.springframework.context.annotation.*;


/**
 * @ComponentScan 包扫描灵活的制定相应的策略
 */
@Configuration
//@ComponentScan(value="com.lanmo")
//@ComponentScan(value="com.lanmo",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//})

//@ComponentScan(value="com.lanmo",includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
//},useDefaultFilters = false)

@ComponentScans(value = {
        @ComponentScan(value="com.lanmo",includeFilters = {
//                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class}),
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class})
        },useDefaultFilters = false)}
)
//excludeFilters 排除那些类注入
//includeFilters
//FilterType.ANNOTATION
//    ANNOTATION  按照注解
//    ASSIGNABLE_TYPE 指定类型
//    ASPECTJ   aspj表达式
//    REGEX     正则表达式
//    CUSTOM 自定义规则
public class MainConfig {

    @Bean
    public Student student(){
        return new Student("张三",11333);
    }

    @Bean
    public Student anOtherstudent(){
        return new Student("张三",11333);
    }

}
