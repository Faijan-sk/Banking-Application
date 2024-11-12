package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entities.Transaction;

public interface TransactionService {
	
	List<Transaction> getTransactionsByAccountId(Long accountId);
	
	String withdrawAmount(Long accountId, double amount);  
	
	String creditAmount(Long accountId, double amount);
	
    String transferAmount(Long senderAccountId, Long receiverAccountId, double amount); 
}
