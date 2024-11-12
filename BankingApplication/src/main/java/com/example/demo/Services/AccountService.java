package com.example.demo.Services;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.Entities.Account;


public interface AccountService {
	
	Account createAccount(Account account);
	
    Account getAccountById(Long accountId);
    
    List<Account> getAllAccounts();
    
    void updateAccountBalance(Long accountId, BigDecimal newBalance);
    
    void deleteAccount(Long accountId);
    

}
