package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findByAccountId(Long accountId);

}
