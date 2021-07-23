package xyz.guawaz;

import static org.junit.Assert.assertTrue;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import xyz.guawaz.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AppTest 
{

    @Test
    public void test1() throws IOException {
        //1.定义mybatis主配置文件的名称
        String config = "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.【重要】获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6.【重要】指定要执行的sql语句的标识。sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "xyz.guawaz.dao.StudentDao.insertStudent";
        //7.执行sql语句，通过sqlId找到语句
        Student stu = new Student();
         stu.setId(1007);
         stu.setName("JayChou");
         stu.setEmail("Jay@qq.com");
         stu.setAge(33);
        int nums = sqlSession.insert(sqlId,stu);

        //提交事务,mybatis默认不是自动提交事务的
        sqlSession.commit();


        //8.输出结果
        System.out.println("成功将"+nums+"条学生信息插入student表");
        //9.关闭sqlSession对象
        sqlSession.close();
    }

}
