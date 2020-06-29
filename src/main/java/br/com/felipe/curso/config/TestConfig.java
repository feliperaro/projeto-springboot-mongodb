package br.com.felipe.curso.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.felipe.curso.domain.Post;
import br.com.felipe.curso.domain.User;
import br.com.felipe.curso.repository.PostRepository;
import br.com.felipe.curso.repository.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Marrom", "maria@gmail.com");
		User alex = new User(null, "Alex Verde", "alex@gmail.com");
		User bob = new User(null, "Bob Cinza", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("29/06/2020"), "Partiu viagem!", "Vou viajar para o Rio de Janeiro. Abraços!", maria);
		Post post2 = new Post(null, sdf.parse("20/06/2020"), "Bom dia", "Acordei feliz hoje...", maria);

		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}

}
