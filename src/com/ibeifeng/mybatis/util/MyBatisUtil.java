package com.ibeifeng.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/2/22.
 */
public class MyBatisUtil {
    private static SqlSessionFactory factory = null;
    static{
        try {
            //1.创建MyBatis配置文件输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //2.创建SqlSessionFactory
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //获取SqlSession
    public static SqlSession GetSession(){
        return factory.openSession();
    }
    //关闭session
    public static  void  close(SqlSession session){
        if(session !=null){
            session.close();
        }
    }
}
