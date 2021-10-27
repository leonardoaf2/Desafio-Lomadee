package br.com.lomadee.desafio.controller;

import java.util.List;
import java.util.Optional;

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

import br.com.lomadee.desafio.model.Customer;
import br.com.lomadee.desafio.model.UsuarioLogin;
import br.com.lomadee.desafio.repository.CustomerRepository;
import br.com.lomadee.desafio.service.UsuarioService;



@Controller
@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
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
	
	@PutMapping
	public ResponseEntity<Customer> put (@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(customer));
	}
	
	@PostMapping
	public ResponseEntity<Customer> post (@RequestBody Customer customer){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(customer));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user) {
		return usuarioService.logar(user)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Customer> Post(@RequestBody Customer customer) {

		Customer usuarioResp = usuarioService.cadastrarUsuario(customer);
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResp);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	
}