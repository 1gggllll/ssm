import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.ioc.test.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * ClassName: JdbcTemplateTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author LLLLB
 * @Create 2024/5/8 20:04
 * @Version 1.0
 */
public class JdbcTemplateTest {

    //    public void test1() throws Exception {
//   利用java代码进行实例化
//        Properties prop = new Properties();
//        prop.load(JdbcTemplateTest.class.getClassLoader().getResourceAsStream("druid.properties"));
//    DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
//    JdbcTemplate jdbcTemplate = new JdbcTemplate();
//    jdbcTemplate.setDataSource(dataSource);
    @Test
    public void test1() {
        //1.创建ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring01.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?);";
        int rows = jdbcTemplate.update(sql,9, "小红", "女", "18", "一年2班");//数据的增删改
        System.out.println(rows);
        sql = "select * from students where id =?";
        Student student = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            //自己处理结果映射
            Student stu = new Student();
            stu.setId(rs.getInt("id"));
            stu.setName(rs.getString("name"));
            stu.setAge(rs.getInt("age"));
            stu.setGender(rs.getString("gender"));
            stu.setClasses(rs.getString("class"));
            return stu;
        }, 2);
        System.out.println("student = " + student);
    }
}
