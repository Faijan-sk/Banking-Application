package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entities.User;
import com.example.demo.Services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/add")
    public String createUser(@ModelAttribute("user") User user) { 
 
        User createdUser = userService.createUser(user);
    
        return "redirect:/users/allUser"; 
       
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/allUser")
    public String getAllUsers(Model model){

		List<User> users = userService.getAllUsers();
    	  
    	  model.addAttribute("user", users);

          return "allUsers";
    }

	 @GetMapping("/getUser/{id}")
	    public String getUserById(@PathVariable("id") Long userId, Model model) {
		 
	        User user = userService.getUserById(userId);
	 
	        model.addAttribute("userdetail", user);
	        
	        return "singleUser";
	    }
	 
	 
	 
	
	    @PreAuthorize("hasRole('ADMIN')")
	    @GetMapping("/editUser/{id}")
	    public String showUpdateForm(@PathVariable("id") Long userId, Model model) {
	        User user = userService.getUserById(userId);
	        if (user != null) {
	            model.addAttribute("user", user);  
	            return "editUserProfile";
	        } else {
	            return "redirect:/users/allUser"; 
	        }
	    }

	    // Update user profile
	    @PostMapping("/updateUser/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    public String updateUser(@PathVariable("id") Long userId, @ModelAttribute("user") User user, Model model) {
	        User existingUser = userService.getUserById(userId);
	        if (existingUser != null) {
	            existingUser.setUsername(user.getUsername());
	            existingUser.setEmail(user.getEmail());
	            existingUser.setFirstName(user.getFirstName());
	            existingUser.setLastName(user.getLastName());

	            // Update the user profile in the database
	            userService.updateUser(userId, existingUser);

	            return "redirect:/users/getUser/" + userId;  
	        }
	        return "redirect:/users/allUser";  
	    }
	    
	    @DeleteMapping("/deleteUser/{id}")
	    @PreAuthorize("hasRole('ADMIN')")
	    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	    	User existingUser = userService.getUserById(id);
	        if (existingUser == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); 
	        }

	        userService.deleteUser(id);

	        
	        return ResponseEntity.noContent().build(); 
	    }

	 
}
