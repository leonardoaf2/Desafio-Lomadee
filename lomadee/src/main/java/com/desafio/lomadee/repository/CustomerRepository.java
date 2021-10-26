package com.desafio.lomadee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.lomadee.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public List<Customer> findAllByNameContainingIgnoreCase (String name);
	

}
