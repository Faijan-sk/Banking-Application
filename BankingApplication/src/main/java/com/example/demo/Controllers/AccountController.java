package com.example.demo.Controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.Entities.Account;
import com.example.demo.Entities.User;
import com.example.demo.Services.AccountService;
import com.example.demo.Services.UserService;

@Controller
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
    private AccountService accountService;

    @Autowired
    private UserService userService;

    @GetMapping("/showcreate") 
    public String showCreateAccountForm(Model model) {
       
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        
        
        model.addAttribute("account", new Account());
        
        return "createAccount";  // Make sure your JSP page name is correct
    }

    @PostMapping("/create")
    public String createAccount(@ModelAttribute("account") Account account) {
        
        accountService.createAccount(account);
        
       
        return "redirect:/accounts/all";
    }
    
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public String getAllAccounts(Model model) {
        List<Account> accounts = accountService.getAllAccounts();
        model.addAttribute("accounts", accounts);
        return "allAccounts"; 
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccountById(id);
        if (account != null) {
            return ResponseEntity.ok(account);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "redirect:/accounts/all";
    }

    @GetMapping("/updateBalance/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showUpdateBalanceForm(@PathVariable Long id, Model model) {
        Account account = accountService.getAccountById(id);
        if (account == null) {
            return "errorPage"; 
        }
        model.addAttribute("account", account);
        return "updateBalance"; 
    }

    @PostMapping("/updateBalance/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String updateAccountBalance(@PathVariable Long id, @RequestParam BigDecimal balance) {
        accountService.updateAccountBalance(id, balance);
        return "redirect:/accounts/all";
    }
}
