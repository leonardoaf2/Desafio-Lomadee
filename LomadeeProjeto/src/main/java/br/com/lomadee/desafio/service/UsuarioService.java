package br.com.lomadee.desafio.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.lomadee.desafio.model.Customer;
import br.com.lomadee.desafio.model.UsuarioLogin;
import br.com.lomadee.desafio.repository.CustomerRepository;


@Service
public class UsuarioService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer cadastrarUsuario(Customer customer) {

		if (customerRepository.findByEmail(customer.getEmail()).isPresent())
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(customer.getSenha());
		customer.setSenha(senhaEncoder);

		return customerRepository.save(customer);
	}

	
	public Optional<UsuarioLogin> logar(Optional<UsuarioLogin> usuarioLogin) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Customer> customer = customerRepository.findByEmail(usuarioLogin.get().getEmail());

		if (customer.isPresent()) {
			if (encoder.matches(usuarioLogin.get().getSenha(), customer.get().getSenha())) {

				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				usuarioLogin.get().setId(customer.get().getId());
				usuarioLogin.get().setNome(customer.get().getName());
				usuarioLogin.get().setSenha(customer.get().getSenha());
				usuarioLogin.get().setToken(authHeader);

				return usuarioLogin;

			}
		}
		
		throw new ResponseStatusException(
				HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos!", null);
		
	}

}