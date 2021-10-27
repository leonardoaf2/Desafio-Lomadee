package br.com.lomadee.desafio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lomadee.desafio.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public List<Customer> findAllByNameContainingIgnoreCase (String name);
	
	public Optional<Customer> findByEmail(String email);

}