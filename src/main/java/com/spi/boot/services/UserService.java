package com.spi.boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spi.boot.entity.Users;
import com.spi.boot.repo.UserRepo;

@Component
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public Users addUser(Users user) {
		userRepo.save(user);
		return user;
	}
	
	public List<Users> addAllUsers(List<Users> users){
		return (List<Users>) userRepo.saveAll(users);
	}
	
	public List<Users> getAllUsers(){
		return (List<Users>) userRepo.findAll();
	}
	
	public Users getUserById(int id) {
		return userRepo.getUserById(id);
	}
	
	public Users deleteUser(int id) {
		Users user = userRepo.getUserById(id);
		userRepo.delete(user);
		return user;
	}
	
	public Users updateUser(int id, Users user) {
		Users update = userRepo.getUserById(id);
		update.setfood(user.getfood());
		update.setLocation(user.getLocation());
		update.setName(user.getName());
		userRepo.save(update);
		return update;
	}
	
	
}
