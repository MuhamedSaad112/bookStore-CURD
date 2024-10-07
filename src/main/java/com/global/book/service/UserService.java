package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.User;
import com.global.book.repository.UserRepo;

@Service
public class UserService extends BaseService<User, Long> {

	@Autowired
	private UserRepo userRepo;

	public User findById(Long id) {

		return userRepo.findById(id).get();
	}

	public List<User> findAll() {

		return userRepo.findAll();
	}

	public User insert(User entity) {
		return userRepo.save(entity);
	}

	public User updata(User entity) {

		User dem = findById(entity.getId());

		dem.setUserName(entity.getUserName());
		dem.setEmail(entity.getEmail());
		dem.setPassword(entity.getPassword());
		dem.setRoles(entity.getRoles());
		return userRepo.save(dem);
	}

	public void delete(User entity) {
		userRepo.delete(entity);
	}

	public boolean existsById(Long id) {
		return userRepo.existsById(id);

	}

	public Long countAll() {
		return userRepo.count();

	}

}