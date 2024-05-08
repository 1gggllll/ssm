package com.my.ioc_03;

/**
 * ClassName: set
 * Package: com.my.ioc_03
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/5/8 17:16
 * @Version 1.0
 */
public class set {
    /**
     * <bean id="simpleMovieLister" class="examples.SimpleMovieLister">
     *   <!-- setter方法，注入movieFinder对象的标识id
     *        name = 属性名  ref = 引用bean的id值
     *    -->
     *   <property name="movieFinder" ref="movieFinder" />
     *
     *   <!-- setter方法，注入基本数据类型movieName
     *        name = 属性名 value= 基本类型值
     *    -->
     *   <property name="movieName" value="消失的她"/>
     * </bean>
     *
     * <bean id="movieFinder" class="examples.MovieFinder"/>
     */
}
