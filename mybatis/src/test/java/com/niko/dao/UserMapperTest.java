package com.niko.dao;

import com.niko.pojo.User;
import com.niko.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void TestSelect(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void TestSelectByIdAndMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id",5);
        System.out.println(mapper.getUserByIdAndMap(map));
        sqlSession.close();
    }

    @Test
    public void TestAddUser(){
        SqlSession ss = MybatisUtils.getSqlSession();
        UserMapper um = ss.getMapper(UserMapper.class);
        User user = new User(4,"yuchuo","478464");
        int number = um.addUser(user);
        if (number > 0) {
            ss.commit();
        }
        List<User> userList = um.getUserList();
        for (User user1 : userList) {
            System.out.println(user1 );
        }
        ss.close();
    }

    @Test
    public void TestUpdateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int number = mapper.updateUser(new User(4, "danxiaoyu", "000000"));
        if (number > 0){
            sqlSession.commit();
        }
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void TestDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(3);
        if (i > 0) {
            sqlSession.commit();
        }
        for (User user : mapper.getUserList()) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void TestAddUserByMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userid",5);
        map.put("username","zhangshuangyi");
        map.put("userpassword","222222");
        int number = mapper.addUserByMap(map);
        if(number > 0){
            sqlSession.commit();
        }
        for (User user : mapper.getUserList()) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void TestSelectLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (User user : mapper.getUserListLike("%li%")) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
