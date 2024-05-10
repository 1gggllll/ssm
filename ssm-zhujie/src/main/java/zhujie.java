import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

/**
 * ClassName: zhujie
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/5/9 17:26
 * @Version 1.0
 */
@Controller
public class zhujie {
//     <!-- 配置自动扫描的包 -->
//    <!-- 1.包要精准,提高性能!
//            2.会扫描指定的包和子包内容
//         3.多个包可以使用,分割 例如: com.atguigu.controller,com.atguigu.service等
//    -->
//    <context:component-scan base-package="com.atguigu.components"/>
//    <!-- 情况三：指定不扫描的组件 -->
//<context:component-scan base-package="com.atguigu.components">
//
//    <!-- context:exclude-filter标签：指定排除规则 -->
//    <!-- type属性：指定根据什么来进行排除，annotation取值表示根据注解来排除 -->
//    <!-- expression属性：指定排除规则的表达式，对于注解来说指定全类名即可 -->
//    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
//</context:component-scan>
public class BeanOne {

    //周期方法要求： 方法命名随意，但是要求方法必须是 public void 无形参列表
    @PostConstruct  //注解制指定初始化方法
    public void init() {
        // 初始化逻辑
    }
}

    public class BeanTwo {

        @PreDestroy //注解指定销毁方法
        public void cleanup() {
            // 释放资源逻辑
        }
    }

//
    //DI的配置
//    @Controller(value = "tianDog")
//    public class SoldierController {
//
//        @Autowired  直接写这个注解，省去了写一个setter方法，除了放在属性上也 可以放在setter方法上或者构造函数上
//        private SoldierService soldierService;
//
//        public void getMessage() {
//            soldierService.getMessage();
//        }
//
//    }


//
    //标注当前类是配置类，替代application.xml
//    @Configuration
////引入jdbc.properties文件
//    @PropertySource({"classpath:application.properties","classpath:jdbc.properties"})
//    @ComponentScan(basePackages = {"com.atguigu.components"})
//    public class MyConfiguration {
//
//        //如果第三方类进行IoC管理,无法直接使用@Component相关注解
//        //解决方案: xml方式可以使用<bean标签
//        //解决方案: 配置类方式,可以使用方法返回值+@Bean注解
//        @Bean
//        public DataSource createDataSource(@Value("${jdbc.user}") String username,
//                                           @Value("${jdbc.password}")String password,
//                                           @Value("${jdbc.url}")String url,
//                                           @Value("${jdbc.driver}")String driverClassName){
//            //使用Java代码实例化
//            DruidDataSource dataSource = new DruidDataSource();
//            dataSource.setUsername(username);
//            dataSource.setPassword(password);
//            dataSource.setUrl(url);
//            dataSource.setDriverClassName(driverClassName);
//            //返回结果即可
//            return dataSource;
//        }
//    }
}
