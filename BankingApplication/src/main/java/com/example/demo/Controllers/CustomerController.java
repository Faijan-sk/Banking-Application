package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.Entities.Customer;
import com.example.demo.Entities.User;
import com.example.demo.Services.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	 @Autowired
	    private CustomerService customerService;

	    // Show all customers
	    @PreAuthorize("hasRole('ADMIN')")
	    @GetMapping("/allCustomer")
	    public String showCustomerList(Model model) {
	        List<Customer> customers = customerService.getAllCustomers();
	        model.addAttribute("customer", customers); 
	        return "customer-list"; 
	    }

	    // Show customer details
	    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	    public String getCustomerById(@PathVariable("id") Long id, Model model) {
	        Customer customer = customerService.getCustomerById(id);
	        if (customer != null) {
	            model.addAttribute("customer", customer);
	            return "customer-details";
	        }
	        return "redirect:/customers/allCustomer";
	    }

	    // Show add customer form
	    @RequestMapping(value = "/add", method = RequestMethod.GET)
	    public String addCustomerForm(@ModelAttribute ("customer") Customer customer) {
	        
	    	Customer createdCustomer = customerService.createCustomer(customer);
	    	
	        return "redirect:/customers/list"; 
	    }

	   
	    @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public String addCustomer(Customer customer) {
	        customerService.createCustomer(customer);
	        return "redirect:/customers/list";
	    }

	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	    @PreAuthorize("hasRole('ADMIN')")
	    public String editCustomerForm(@PathVariable("id") Long id, Model model) {
	        Customer customer = customerService.getCustomerById(id);
	        if (customer != null) {
	            model.addAttribute("customer", customer);
	            return "edit-customer"; 
	        }
	        return "redirect:/customers/allCustomer"; 
	    }

	    
	    @PreAuthorize("hasRole('ADMIN')")
	    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	    public String updateCustomer(@PathVariable("id") Long id, @ModelAttribute("customer") Customer customer) {
	        Customer existingCustomer = customerService.getCustomerById(id);
	        if (existingCustomer != null) {
	            // Only update necessary fields
	            existingCustomer.setAddress(customer.getAddress());
	            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
	            existingCustomer.setDateOfBirth(customer.getDateOfBirth());

	            customerService.updateCustomer(id, existingCustomer);
	            return "redirect:/customers/allCustomer"; 
	        }
	        return "redirect:/customers/allCustomer";
	    }

	    // Delete customer
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    @PreAuthorize("hasRole('ADMIN')")
	    public String deleteCustomer(@PathVariable("id") Long id) {
	        customerService.deleteCustomer(id);
	        return "redirect:/customers/list"; 
	    }
}