package com.paisabook.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paisabook.daos.TransactionDao;
import com.paisabook.daos.UserDao;
import com.paisabook.entities.Transaction;
import com.paisabook.entities.User;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userdao;
	
	@Autowired
	TransactionDao transactiondao;
	
	@Override
	public User saveUser(User u) {
		return userdao.save(u);
	}

	@Override
	public User getUserData(int id) {
		if(userdao.existsById(id)) {
			return userdao.findById(id).orElse(null);
		}
		else {
			return null;
		}
	}

	@Override
	public List<Transaction> getAllTransactionsByUserId(int id) {
		return transactiondao.findByUserUserId(id).orElse(null);
		
	}

	

}
