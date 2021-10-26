package com.desafio.lomadee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.lomadee.model.Address;
import com.desafio.lomadee.repository.AddressRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/address")
public class AddressController {
	
	
	@Autowired
	private AddressRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Address>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/zipCode/{zipCode}")
	public ResponseEntity<List<Address>> getByZipCode(@PathVariable String zipCode){
		return ResponseEntity.ok(repository.findAllByZipCodeContainingIgnoreCase(zipCode));
	}
	
	@GetMapping("/customer/{customer}")
	public ResponseEntity<List<Address>> getByCustomer(@PathVariable String customer){
		return ResponseEntity.ok(repository.findAllByZipCodeContainingIgnoreCase(customer));
	}
	
	@PostMapping
	public ResponseEntity<Address> post (@RequestBody Address address){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(address));
	}
	
	@PutMapping
	public ResponseEntity<Address> put (@RequestBody Address address){
		return ResponseEntity.ok(repository.save(address));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
