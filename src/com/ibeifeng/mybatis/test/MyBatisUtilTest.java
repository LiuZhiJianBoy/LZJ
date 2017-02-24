package com.ibeifeng.mybatis.test;

import com.ibeifeng.mybatis.model.User;
import com.ibeifeng.mybatis.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Administrator on 2017/2/22.
 */
public class MyBatisUtilTest {
    //添加信息
    @Test
    public void testAdd(){
        SqlSession session = MyBatisUtil.GetSession();
        User user = new User("小赖","38389438");
        session.insert(User.class.getName()+".add",user);
        session.commit();
        MyBatisUtil.close(session);
    }
    //修改信息
    @Test
    public void testUpdate(){
        SqlSession session = MyBatisUtil.GetSession();
        User user = new User("小小赖","38389438");
        user.setId(8);
        session.insert(User.class.getName()+".update",user);
        session.commit();
        MyBatisUtil.close(session);
    }
    //删除信息
    @Test
    public void testDel(){
        SqlSession session = MyBatisUtil.GetSession();
        session.insert(User.class.getName()+".del",3);
        session.commit();
        MyBatisUtil.close(session);
    }
    @Test
    public void testLoad(){
        SqlSession session = MyBatisUtil.GetSession();

    }
}
