package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.Order;
import com.global.book.entity.User;
import com.global.book.repository.OrderRepo;

@Service
public class OrderService extends BaseService<Order, Long> {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private UserService userService;

	public Order findById(Long id) {

		return orderRepo.findById(id).get();
	}

	public List<Order> findAll() {

		return orderRepo.findAll();
	}

	public Order insert(Order entity) {

		if (entity.getUser() != null && entity.getUser().getId() != null) {
			User user = userService.findById(entity.getUser().getId());
			entity.setUser(user);
		}
		return orderRepo.save(entity);
	}

	public Order updata(Order entity) {

		Order dem = findById(entity.getId());

		dem.setStatus(entity.getStatus());
		dem.setUser(entity.getUser());

		return orderRepo.save(dem);
	}

	public void delete(Order entity) {
		orderRepo.delete(entity);
	}

	public boolean existsById(Long id) {
		return orderRepo.existsById(id);

	}

	public Long countAll() {
		return orderRepo.count();

	}

}