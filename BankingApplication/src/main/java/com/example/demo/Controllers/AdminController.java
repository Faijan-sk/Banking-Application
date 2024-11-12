package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Entities.Admin;
import com.example.demo.Services.AdminService;

@Controller
@RequestMapping("/admins")
public class AdminController {
	
	 @Autowired
	    private AdminService adminService;
	 
	 	
	    @GetMapping("/all")
	    public String getAllAdmins(Model model) {
	        model.addAttribute("admins", adminService.findAllAdmins());
	        return "allAdmins";  // JSP page to list all admins
	    }

	    @GetMapping("/create")
	    public String showCreateForm(Model model) {
	        model.addAttribute("admin", new Admin());
	        return "createAdmin";  // JSP page to create a new admin
	    }

	    @PostMapping("/create")
	    public String createAdmin(@ModelAttribute Admin admin) {
	        adminService.saveAdmin(admin);
	        return "redirect:/admins/all";
	    }

	    @GetMapping("/edit/{id}")
	    public String showEditForm(@PathVariable Long id, Model model) {
	        Admin admin = adminService.findAdminById(id);
	        if (admin != null) {
	            model.addAttribute("admin", admin);
	            return "editAdmin";  // JSP page to edit admin details
	        }
	        return "redirect:/admins/all";
	    }

	    @PostMapping("/edit/{id}")
	    public String updateAdmin(@PathVariable Long id, @ModelAttribute Admin admin) {
	        adminService.updateAdmin(id, admin);
	        return "redirect:/admins/all";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteAdmin(@PathVariable Long id) {
	        adminService.deleteAdmin(id);
	        return "redirect:/admins/all";
	    }

}
