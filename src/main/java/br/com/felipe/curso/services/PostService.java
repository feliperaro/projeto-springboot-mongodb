package br.com.felipe.curso.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.felipe.curso.domain.Post;
import br.com.felipe.curso.repository.PostRepository;
import br.com.felipe.curso.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> obj = postRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!"));
	}

}
