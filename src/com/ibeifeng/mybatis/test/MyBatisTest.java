package com.ibeifeng.mybatis.test;

import com.ibeifeng.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/22.
 */
public class MyBatisTest {
    @Test
    public void testAdd(){
        try {
            //1.创建MyBatis配置文件输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //3.获取SqlSession
            SqlSession session = factory.openSession();
            //4.进行保存操作
            User user =  new User("戴程利","38389438");
            session.insert("com.ibeifeng.mybatis.model.User.add",user);
            //5.提交事务
             session.commit();
            //6.关闭session
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
    @Test
    public void testUpdate(){
        try {
            //1.创建MyBatis配置文件输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //3.获取SqlSession
            SqlSession session = factory.openSession();
            User user = new User("东华","111");
            user.setId(1);
            session.update("com.ibeifeng.mybatis.model.User.update",user);
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDel(){
        try {
            //1.创建MyBatis配置文件输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建SqlSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //3.获取SqlSession
            SqlSession session = factory.openSession();
            //4.进行保存操作
            session.delete(User.class.getName()+".del",1);
            //5.提交事务
            session.commit();
            //6.关闭session
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

}
