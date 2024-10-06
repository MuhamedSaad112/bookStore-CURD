package com.global.book.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Order;

@Repository
public interface OrderRepo extends BaseRepository<Order, Long> {

	@Query(value = "SELECT COUNT(*) FROM orders", nativeQuery = true)
	long count();

}
