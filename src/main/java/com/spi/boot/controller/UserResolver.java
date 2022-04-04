package com.spi.boot.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spi.boot.entity.Food;
import com.spi.boot.entity.Users;
import com.spi.boot.services.UserService;

@RestController
public class UserResolver {

	@Autowired
	UserService userService;

//	--------------------------------------------------- User -------------------------------------------------------------------
	@GetMapping("/user")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> list;
		try {
			list = userService.getAllUsers();
			return ResponseEntity.of(Optional.of(list));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping("/user/{id}")
	public ResponseEntity<Users> getUserById(@PathVariable int id) {
		Users u = null;
		try {
			u = userService.getUserById(id);
			return ResponseEntity.of(Optional.of(u));
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (NullPointerException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PostMapping("/user")
	public ResponseEntity<Food> addUser(@RequestBody Users u) {
		try {
			userService.addUser(u);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PostMapping("/users")
	public ResponseEntity<List<Users>> addUsers(@RequestBody List<Users> l) {
		try {
			userService.addAllUsers(l);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("user/{id}")
	public ResponseEntity<Users> deleteUser(@PathVariable int id) {
		try {
			userService.deleteUser(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@PutMapping("/user/{id}")
	public ResponseEntity<Users> updateUser(@PathVariable int id, Users user) {
		try {
			userService.updateUser(id, user);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
