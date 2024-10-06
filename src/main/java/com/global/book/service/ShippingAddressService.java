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
	private ShippingAddressRepo addressService;

	public List<ShippingAddress> findByAddressByUserId(Long userId) {

		return addressService.findByAddressUserId(userId);
	}

	public ShippingAddress findById(Long id) {

		return addressService.findById(id).get();
	}

	public List<ShippingAddress> findAll() {

		return addressService.findAll();
	}

	public ShippingAddress insert(ShippingAddress entity) {
		return addressService.save(entity);
	}

	public ShippingAddress updata(ShippingAddress entity) {

		ShippingAddress dem = findById(entity.getId());

		dem.setAddress(entity.getAddress());
		dem.setCountry(entity.getCountry());
		dem.setPostCode(entity.getPostCode());
		dem.setUser(entity.getUser());

		return addressService.save(dem);
	}

	public void delete(ShippingAddress entity) {
		addressService.delete(entity);
	}

	public boolean existsById(Long id) {
		return addressService.existsById(id);

	}

	public Long countAll() {
		return addressService.count();

	}

}
