package com.global.book.repository;

import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.OrderDetails;

@Repository
public interface OrderDetailsRepo extends BaseRepository<OrderDetails, Long> {

	OrderDetails findByOrderId(Long id);
}
