package com.mybatis.service;

import com.mybatis.entity.User;

import java.util.List;

/**
 * Created by user on 2017/6/6.
 */
public interface UserService {
    void save(User user);
    boolean update(User user);
    boolean delete(int id);
    User findById(int id);
    List<User> findAll();
}
