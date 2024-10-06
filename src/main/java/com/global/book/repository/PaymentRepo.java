package com.global.book.repository;

import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.Payment;

@Repository
public interface PaymentRepo extends BaseRepository<Payment, Long> {

}
