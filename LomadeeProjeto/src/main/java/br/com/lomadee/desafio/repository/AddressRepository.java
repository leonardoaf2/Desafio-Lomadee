package br.com.lomadee.desafio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lomadee.desafio.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
	
	public List<Address> findAllByZipCodeContainingIgnoreCase(String ZipCode);
	
}