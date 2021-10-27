package br.com.lomadee.desafio.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lomadee.desafio.model.Customer;
import br.com.lomadee.desafio.repository.CustomerRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Customer> customer = customerRepository.findByEmail(email);
		customer.orElseThrow(() -> new UsernameNotFoundException(email + " not found."));

		return customer.map(UserDetailsImpl::new).get();
	}
}

