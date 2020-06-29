package br.com.felipe.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.felipe.curso.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
