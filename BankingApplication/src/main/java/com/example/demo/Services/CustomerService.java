package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Entities.Customer;

@Service
public interface CustomerService {
	
	Customer createCustomer(Customer customer);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    Customer updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long id);
}