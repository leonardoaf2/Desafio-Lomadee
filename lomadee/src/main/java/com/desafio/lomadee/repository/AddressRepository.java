package com.desafio.lomadee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.lomadee.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
	public List<Address> findAllByZipCodeContainingIgnoreCase(String ZipCode);
	
}
