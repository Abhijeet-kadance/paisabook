package com.paisabook.services;



import java.util.List;

import com.paisabook.entities.Transaction;
import com.paisabook.entities.User;


public interface UserService {
	
	User saveUser(User u);
	User getUserData(int id);
	List<Transaction>getAllTransactionsByUserId(int id);
}
