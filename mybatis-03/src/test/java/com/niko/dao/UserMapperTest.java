package com.niko.dao;

import com.niko.pojo.User;
import com.niko.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void Test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.getUserById(1)
        System.out.println(user);
        sqlSession.close();
    }
}
