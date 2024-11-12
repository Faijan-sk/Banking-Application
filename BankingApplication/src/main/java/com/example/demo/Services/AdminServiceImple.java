package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Admin;
import com.example.demo.Repositories.AdminRepository;

@Service	
public class AdminServiceImple implements AdminService {

	    @Autowired
	    private AdminRepository adminRepository;

	    @Override
	    public Admin saveAdmin(Admin admin) {
	        return adminRepository.save(admin);
	    }

	    @Override
	    public Admin findAdminById(Long id) {
	        return adminRepository.findById(id).orElse(null);
	    }

	    @Override
	    public Optional<Admin> findAdminByUsername(String username) {
	        return Optional.ofNullable(adminRepository.findByUsername(username));
	    }

	    @Override
	    public Optional<Admin> findAdminByEmail(String email) {
	        return adminRepository.findByEmail(email);
	    }

	    @Override
	    public List<Admin> findAllAdmins() {
	        return adminRepository.findAll();
	    }

	    @Override
	    public void deleteAdmin(Long id) {
	        adminRepository.deleteById(id);
	    }

	    @Override
	    public Admin updateAdmin(Long id, Admin admin) {
	        if (adminRepository.existsById(id)) {
	            admin.setId(id);
	            return adminRepository.save(admin);
	        }
	        return null;
	    }

}
