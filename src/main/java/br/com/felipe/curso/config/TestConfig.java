package br.com.felipe.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.felipe.curso.domain.User;
import br.com.felipe.curso.repository.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Marrom", "maria@gmail.com");
		User alex = new User(null, "Alex Verde", "alex@gmail.com");
		User bob = new User(null, "Bob Cinza", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
	}

}
