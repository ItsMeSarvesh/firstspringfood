package com.spi.boot.repo;

import org.springframework.data.repository.CrudRepository;

import com.spi.boot.entity.Users;

public interface UserRepo extends CrudRepository<Users, Integer> {
	public Users getUserById(int id);
}
