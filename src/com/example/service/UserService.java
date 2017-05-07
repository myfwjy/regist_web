package com.example.service;

import com.example.domain.User;

public interface UserService {

	void regist(User user) throws Exception;

	User findByCode(String code) throws Exception;

	void update(User user) throws Exception;

}
