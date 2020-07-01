package br.com.felipe.curso.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.felipe.curso.domain.Post;
import br.com.felipe.curso.domain.User;
import br.com.felipe.curso.dto.AuthorDTO;
import br.com.felipe.curso.dto.CommentDTO;
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

		Post post1 = new Post(null, sdf.parse("29/06/2020"), "Partiu viagem!",
				"Vou viajar para o Rio de Janeiro. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("20/06/2020"), "Bom dia", "Acordei feliz hoje...", new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2020"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2020"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2020"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
	}
}
