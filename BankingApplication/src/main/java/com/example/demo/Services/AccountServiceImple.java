package com.example.demo.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Account;
import com.example.demo.Repositories.AccountRepository;

@Service
public class AccountServiceImple implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId).orElse(null);
    }

    @Override
    public void updateAccountBalance(Long accountId, BigDecimal newBalance) {
        Account account = getAccountById(accountId);
        if (account != null) {
            account.setBalance(newBalance);
            accountRepository.save(account);
        }
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
	}
