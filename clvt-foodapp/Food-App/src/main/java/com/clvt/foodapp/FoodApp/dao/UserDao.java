package com.clvt.foodapp.FoodApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.clvt.foodapp.FoodApp.dto.User;
import com.clvt.foodapp.FoodApp.repository.UserRepository;

@Repository
public class UserDao {
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	public String deleteUser(int id) {
		User user = getUserById(id);
		if(user!=null) {
			userRepository.delete(user);
			return user.getId()+" "+user.getName()+" is deleted sucessfully";
		}
		else {
			return "No user found";
		}
	}
	public User getUserById(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
}
