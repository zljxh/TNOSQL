package com.mybatis.service.impl;

import com.mybatis.database.DbContextHolder;
import com.mybatis.entity.User;
import com.mybatis.entity.mapper.UserMapper;
import com.mybatis.entity.mapper.UserMapper2;
import com.mybatis.service.UserService;
import com.mybatis.service.UserService2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional  //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class UserServiceImpl2 implements UserService2 {

	public UserServiceImpl2() {

	}

	@Resource
	private UserMapper2 mapper;

	public boolean delete(int id) {
		
		return mapper.delete(id);
	}

	public List<User> findAll() {
		List<User> findAllList = mapper.findAll();
		return findAllList;
	}

	public User findById(int id) {

		User user = mapper.findById(id);
		
		return user;
	}

	public void save(User user) {

		mapper.save(user);
	}

	public boolean update(User user) {

		return mapper.update(user);
	}
	
	

}
