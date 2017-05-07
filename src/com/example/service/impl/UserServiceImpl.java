package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	/**
	 * 业务层注册方法
	 */
	public void regist(User user) throws Exception {
		// 数据存入数据库
		UserDao dao = new UserDaoImpl();
		dao.regist(user);
		// 发送一封激活邮件
		MailUtils.sendMail(user.getEmail(), user.getCode());
	}

	@Override
	/**
	 * 根据激活码查询用户
	 */
	public User findByCode(String code) throws Exception{
		UserDao dao = new UserDaoImpl();
		return dao.findByCode(code);		
	}

	@Override
	/**
	 * 修改用户
	 */
	public void update(User user) throws Exception {
		UserDao dao = new UserDaoImpl();
		dao.update(user);
	}

}
