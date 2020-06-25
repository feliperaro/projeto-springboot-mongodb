package br.com.felipe.curso.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.felipe.curso.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
