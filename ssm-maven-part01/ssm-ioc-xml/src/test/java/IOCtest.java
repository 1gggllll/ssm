import com.my.ioc_01.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: IOCtest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/5/8 17:36
 * @Version 1.0
 */
public class IOCtest {
    @Test
    public void creatIOC(){
        //方式1:实例化并且指定配置文件
//参数：String...locations 传入一个或者多个配置文件
        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring01-xml.xml");

//方式2:先实例化，再指定配置文件，最后刷新容器触发Bean实例化动作 [springmvc源码和contextLoadListener源码方式]
        ClassPathXmlApplicationContext context1 =
                new ClassPathXmlApplicationContext();
//设置配置配置文件,方法参数为可变参数,可以设置一个或者多个配置
        context1.setConfigLocations("spring01-xml.xml");
//后配置的文件,需要调用refresh方法,触发刷新配置
        context1.refresh();

    }
    public void getIOC(){
        ClassPathXmlApplicationContext context1 =
                new ClassPathXmlApplicationContext();
        context1.setConfigLocations("spring01-xml.xml");
        context1.refresh();
        //方式1: 根据id获取
//没有指定类型,返回为Object,需要类型转化!
        HappyComponent happyComponent =
                (HappyComponent)  context1.getBean("bean的id标识");

//使用组件对象
        happyComponent.doWork();

//方式2: 根据类型获取
//根据类型获取,但是要求,同类型(当前类,或者之类,或者接口的实现类)只能有一个对象交给IoC容器管理
//配置两个或者以上出现: org.springframework.beans.factory.NoUniqueBeanDefinitionException 问题
        HappyComponent happyComponent2 =  context1.getBean(HappyComponent.class);
        happyComponent.doWork();
/**
 * //TODO:根据bean的类型获取,同一个类型,在ioc容器中只能有一个bean !!!
 * //TODO:如果ioc容器存在多个同类型的Bean 会出现:NoUniqueBeanDefinitionException
 * //TODO:ioc的配置一定是实现类,但是可以根据接口类型获取值!getBean(类型);instanceof ioc容器的类型 ■■true
 */
//方式3: 根据id和类型获取
        HappyComponent happyComponent3 =  context1.getBean("bean的id标识", HappyComponent.class);
        happyComponent.doWork();

        //根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 instanceof 指定的类型』的返回结果，
        //只要返回的是true就可以认定为和类型匹配，能够获取到。
    }

}
