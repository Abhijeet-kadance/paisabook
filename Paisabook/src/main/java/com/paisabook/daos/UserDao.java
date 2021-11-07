package com.paisabook.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paisabook.entities.Transaction;
import com.paisabook.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
}
