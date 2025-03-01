package com.example.canteen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.canteen.model.admin;
import com.example.canteen.repository.admin_repository;

@Service
public class admin_service {
	
	 @Autowired
	    private admin_repository adminRepository;

	    // Register a new admin
	    public admin registerAdmin(admin ad) {
	        return adminRepository.save(ad);
	    }

	    // Find admin by ID
	    public Optional<admin> getAdminById(int id) {
	        return adminRepository.findById((long) id);
	    }

	    // Get all admins
	    public List<admin> getAllAdmins() {
	        return adminRepository.findAll();
	    }

	    // Update admin information
	    public admin updateAdmin(int id, admin updatedAdmin) {
	        if(adminRepository.existsById((long) id)) {
	            updatedAdmin.setId(id);
	            return adminRepository.save(updatedAdmin);
	        } else {
	            throw new RuntimeException("admin not found");
	        }
	    }

	    // Delete an admin by ID
	    public void deleteAdmin(int id) {
	        adminRepository.deleteById((long) id);
	    }

}
