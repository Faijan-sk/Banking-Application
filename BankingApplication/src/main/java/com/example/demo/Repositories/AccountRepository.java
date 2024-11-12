package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
