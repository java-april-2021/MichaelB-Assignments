package com.mbrowley.EventsBeltViewer.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbrowley.EventsBeltViewer.model.User;
import com.mbrowley.EventsBeltViewer.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	//get a user by Id
	public User findUserById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	
	// get all users
	public List<User> getAllUser(){
		return this.uRepo.findAll();
	}
	
	// check if email exist in database
	public boolean emailExist(String email) {
		return uRepo.existsByEmail(email);
	}
	
	//find user by email
	public User findUserByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	//save user
	public void saveUser(User user) {
		this.uRepo.save(user);
	}
	
	//register user
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return uRepo.save(user);
	}

	//authenicate user
	public boolean authenicateUser(String email, String password) {
		//find user by email
		User user = uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}else {
			//use BCrypt to see if password match
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	//delete user
	public void deleteUser(User user) {
		uRepo.delete(user);
	}
}
