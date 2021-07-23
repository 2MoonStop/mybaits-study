package com.niko.dao;

import com.niko.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    User getUserByIdAndMap(Map<String, Object> map);

    int addUser(User user);

    int addUserByMap(Map<String, Object> map);

    int updateUser(User user);

    int deleteUser(int id);

    List<User> getUserListLike(String value);
}
