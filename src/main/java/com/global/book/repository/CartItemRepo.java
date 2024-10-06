package com.global.book.repository;

import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.CartItem;

@Repository
public interface CartItemRepo extends BaseRepository<CartItem, Long> {

	CartItem findByBookId(Long bookId);
}
