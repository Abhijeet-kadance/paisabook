package com.paisabook.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paisabook.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
