package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entities.Transaction;
import com.example.demo.Services.TransactionService;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/allTransaction/{AccountId}")
	public String getAllUsers(@PathVariable("AccountId") Long accId, Model model) {
	    List<Transaction> transactions = transactionService.getTransactionsByAccountId(accId);
	    System.out.println(transactions);
	    model.addAttribute("transaction", transactions);
	    return "allTransactions";
	}
	
	@GetMapping("/withdraw/{accountId}")
	public String showWithdrawForm(@PathVariable("accountId") Long accountId, Model model) {
	    model.addAttribute("accountId", accountId);
	    return "withdraw"; // JSP page
	}

	   
	    @PostMapping("/withdraw")
	    public String withdrawAmount(@RequestParam("amount") double amount,
	                                 @RequestParam("accountId") Long accountId, Model model) {
	    	
	    	
	        String result = transactionService.withdrawAmount(accountId, amount);
	       
	        model.addAttribute("message", result); 
	        return "homePage"; 
	    }
	
	    
	   
	    
	    
	    @GetMapping("/credit/{accountId}")
	    public String showCreditForm(@PathVariable("accountId") Long accountId, Model model) {
	        model.addAttribute("accountId", accountId);
	        return "Credit"; 
	    }

	    @PostMapping("/credit")
	    public String creditAmount(@RequestParam("amount") double amount,
	                               @RequestParam("accountId") Long accountId, Model model) {
	        String result = transactionService.creditAmount(accountId, amount);
	        model.addAttribute("message", result); 
	        return "homePage"; 
	    }
	    
	    
	    
	   
	    
	    @GetMapping("/transfer/{accountId}")
	    public String showTransferForm(@PathVariable("accountId") Long accountId, Model model) {
	        model.addAttribute("senderAccountId", accountId);
	        return "transfer";
	    }

	    // Handle transfer request
	    @PostMapping("/transfer")
	    public String transferAmount(@RequestParam("senderAccountId") Long senderAccountId,
	                                 @RequestParam("receiverAccountId") Long receiverAccountId,
	                                 @RequestParam("amount") double amount, Model model) {
	   
	        String result = transactionService.transferAmount(senderAccountId, receiverAccountId, amount);
	        model.addAttribute("message", result); 
	        return "homePage";
	    }
	    
	

	

}
