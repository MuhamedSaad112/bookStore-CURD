package com.global.book.repository;

import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Cart;

@Repository
public interface CartRepo extends BaseRepository<Cart, Long> {

	Cart findByUserId(Long userId);

}
