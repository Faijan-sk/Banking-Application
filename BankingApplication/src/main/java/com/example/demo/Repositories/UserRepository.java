package com.example.demo.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	User findByUsername(String username);
    User findByEmail(String email);
    User getAccountById(Long accountId);
}
