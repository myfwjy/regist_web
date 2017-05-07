package com.example.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.example.dao.UserDao;
import com.example.domain.User;
import com.example.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

	@Override
	/**
	 * �����û��ķ���
	 */
	public void regist(User user) throws Exception {
		try {
			QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
			String sql = "insert into user values (?,?,?,?,?,?,?)";
			Object[] params = { user.getUid(), user.getUserName(),
					user.getPassword(), user.getNickname(), user.getEmail(),
					user.getState(), user.getCode() };
			queryRunner.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * ���ݼ������ѯ 
	 */
	public User findByCode(String code) throws Exception {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from user where code = ?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class),
				code);
		return user;
	}

	@Override
	/**
	 * �޸��û�
	 */
	public void update(User user) throws Exception {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update user set username=?,password=?,nickname=?,email=?,state=?,code=? where uid=?";
		Object[] params = { user.getUserName(), user.getPassword(),
				user.getNickname(), user.getEmail(), user.getState(),
				user.getCode(), user.getUid() };
		queryRunner.update(sql, params);
	}

}
