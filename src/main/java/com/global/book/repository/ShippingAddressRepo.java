package com.global.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.book.base.BaseRepository;
import com.global.book.entity.ShippingAddress;

@Repository
public interface ShippingAddressRepo extends BaseRepository<ShippingAddress, Long> {



	@Query("SELECT a FROM ShippingAddress a WHERE a.user.id = :userId")
	List<ShippingAddress> findByAddressUserId(@Param("userId") Long userId);
	

  

}
