package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.base.BaseService;
import com.global.book.entity.ShippingAddress;
import com.global.book.repository.ShippingAddressRepo;

@Service
public class ShippingAddressService extends BaseService<ShippingAddress, Long> {

	@Autowired
	private ShippingAddressRepo addressRepo;

	public List<ShippingAddress> findByAddressByUserId(Long userId) {

		return addressRepo.findByAddressUserId(userId);
	}

	public ShippingAddress insert(ShippingAddress entity) {
		return addressRepo.save(entity);
	}

	public ShippingAddress update(ShippingAddress entity) {

		ShippingAddress dem = findById(entity.getId());

		dem.setAddress(entity.getAddress());
		dem.setCountry(entity.getCountry());
		dem.setPostCode(entity.getPostCode());

		return addressRepo.save(dem);
	}

	public void delete(ShippingAddress entity) {
		addressRepo.delete(entity);
	}

}
