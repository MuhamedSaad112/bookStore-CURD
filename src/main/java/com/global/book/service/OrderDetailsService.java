package com.global.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.OrderDetails;
import com.global.book.repository.OrderDetailsRepo;

@Service
public class OrderDetailsService extends BaseService<OrderDetails, Long> {

	@Autowired
	private OrderDetailsRepo orderDetailsRepo;

	public OrderDetails findByOrderId(Long id) {
		return orderDetailsRepo.findByOrderId(id);
	}

	public OrderDetails findById(Long id) {

		return orderDetailsRepo.findById(id).get();
	}

	public OrderDetails insert(OrderDetails entity) {
		return orderDetailsRepo.save(entity);
	}

	public OrderDetails update(OrderDetails entity) {

		OrderDetails dem = findById(entity.getId());

		dem.setBook(entity.getBook());
		dem.setOrder(entity.getOrder());
		dem.setPrice(entity.getPrice());
		dem.setQuantity(entity.getQuantity());

		return orderDetailsRepo.save(dem);
	}

	public void delete(OrderDetails entity) {
		orderDetailsRepo.delete(entity);
	}

	public boolean existsById(Long id) {
		return orderDetailsRepo.existsById(id);

	}


}
