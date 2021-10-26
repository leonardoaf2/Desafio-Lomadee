package com.desafio.lomadee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.lomadee.model.Customer;
import com.desafio.lomadee.repository.CustomerRepository;

@Controller
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Customer>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Customer>> GetByTitulo(@PathVariable String name){
		return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
	}
	
	@PostMapping
	public ResponseEntity<Customer> post (@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(customer));
	}
	
	@PutMapping
	public ResponseEntity<Customer> put (@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(customer));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}