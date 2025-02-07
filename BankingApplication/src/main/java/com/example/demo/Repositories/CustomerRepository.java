package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findByUserId(Long userId);

}
