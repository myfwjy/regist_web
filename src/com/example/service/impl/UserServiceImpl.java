package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.domain.User;
import com.example.service.UserService;
import com.example.utils.MailUtils;

public class UserServiceImpl implements UserService {

	@Override
	/**
	 * ҵ���ע�᷽��
	 */
	public void regist(User user) throws Exception {
		// ���ݴ������ݿ�
		UserDao dao = new UserDaoImpl();
		dao.regist(user);
		// ����һ�⼤���ʼ�
		MailUtils.sendMail(user.getEmail(), user.getCode());
	}

	@Override
	/**
	 * ���ݼ������ѯ�û�
	 */
	public User findByCode(String code) throws Exception{
		UserDao dao = new UserDaoImpl();
		return dao.findByCode(code);		
	}

	@Override
	/**
	 * �޸��û�
	 */
	public void update(User user) throws Exception {
		UserDao dao = new UserDaoImpl();
		dao.update(user);
	}

}
