package br.com.blogapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.blogapi.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
