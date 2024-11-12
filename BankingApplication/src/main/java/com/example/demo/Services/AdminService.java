package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Entities.Admin;

public interface AdminService {
	
	Admin saveAdmin(Admin admin);

    Admin findAdminById(Long id);

    Optional<Admin> findAdminByUsername(String username);

    Optional<Admin> findAdminByEmail(String email);

    List<Admin> findAllAdmins();

    void deleteAdmin(Long id);

    Admin updateAdmin(Long id, Admin admin);

}
