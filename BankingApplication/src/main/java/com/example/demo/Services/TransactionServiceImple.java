package com.example.demo.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Account;
import com.example.demo.Entities.Transaction;
import com.example.demo.Entities.TransactionType;
import com.example.demo.Repositories.AccountRepository;
import com.example.demo.Repositories.TransactionRepository;

@Service
public class TransactionServiceImple implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
    AccountService accountService;

	@Override
	public List<Transaction> getTransactionsByAccountId(Long accountId) {
		
		return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getAccount().getId().equals(accountId))
                .toList();
	}

	
	 @Override
	    public String withdrawAmount(Long accountId, double amount) {
	       
	        Account account = accountService.getAccountById(accountId);
	        if (account == null) {
	            return "Account not found!";
	        }

	       
	        List<Transaction> transactions = transactionRepository.findByAccountId(accountId);
	        double currentBalance = calculateCurrentBalance(transactions);

	        
	        if (currentBalance >= amount) {
	            
	            Transaction newTransaction = new Transaction();
	            newTransaction.setAccount(account);
	            newTransaction.setTransactionType(TransactionType.WITHDRAW); 
	            newTransaction.setAmount(BigDecimal.valueOf(-amount)); 

	            transactionRepository.save(newTransaction); 

	            
	            accountService.updateAccountBalance(accountId, account.getBalance().subtract(BigDecimal.valueOf(amount)));

	            return "Withdrawal successful!";
	        } else {
	            return "Insufficient balance!";
	        }
	    }

	    private double calculateCurrentBalance(List<Transaction> transactions) {
	        return transactions.stream()
	                .mapToDouble(t -> t.getAmount().doubleValue())
	                .sum();
	    }
	    
	    
	    
	    
	    @Override
	    public String creditAmount(Long accountId, double amount) {
	        Account account = accountService.getAccountById(accountId);
	        if (account == null) {
	            return "Account not found!";
	        }

	        // Create new credit transaction
	        Transaction newTransaction = new Transaction();
	        newTransaction.setAccount(account);
	        newTransaction.setTransactionType(TransactionType.DEPOSIT);
	        newTransaction.setAmount(BigDecimal.valueOf(amount)); 

	        transactionRepository.save(newTransaction);

	        
	        accountService.updateAccountBalance(accountId, account.getBalance().add(BigDecimal.valueOf(amount)));

	        return "Credit successful!";
	    }
	    
	    
	    
	    
	    
	    
	    @Override
	    public String transferAmount(Long senderAccountId, Long receiverAccountId, double amount) {
	        Account senderAccount = accountService.getAccountById(senderAccountId);
	        Account receiverAccount = accountService.getAccountById(receiverAccountId);

	        if (senderAccount == null || receiverAccount == null) {
	            return "One or both accounts not found!";
	        }

	        
	        List<Transaction> senderTransactions = transactionRepository.findByAccountId(senderAccountId);
	        double senderCurrentBalance = calculateCurrentBalance(senderTransactions);

	        if (senderCurrentBalance >= amount) {
	           
	            Transaction senderTransaction = new Transaction();
	            senderTransaction.setAccount(senderAccount);
	            senderTransaction.setTransactionType(TransactionType.TRANSFER);
	            senderTransaction.setAmount(BigDecimal.valueOf(-amount)); 

	           
	            Transaction receiverTransaction = new Transaction();
	            receiverTransaction.setAccount(receiverAccount);
	            receiverTransaction.setTransactionType(TransactionType.TRANSFER);
	            receiverTransaction.setAmount(BigDecimal.valueOf(amount)); 

	            
	            transactionRepository.save(senderTransaction);
	            transactionRepository.save(receiverTransaction);

	           
	            accountService.updateAccountBalance(senderAccountId, senderAccount.getBalance().subtract(BigDecimal.valueOf(amount)));
	            accountService.updateAccountBalance(receiverAccountId, receiverAccount.getBalance().add(BigDecimal.valueOf(amount)));

	            return "Transfer successful!";
	        } else {
	            return "Insufficient balance!";
	        }
	    }

	   


	
}
