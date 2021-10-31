package com.paisabook.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paisabook.daos.UserDao;
import com.paisabook.entities.User;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Override
	public User saveUser(User u) {
		return userdao.save(u);
	}

}
