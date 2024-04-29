package com.spring.boot.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findUsersByLastName(String lastName);
}
