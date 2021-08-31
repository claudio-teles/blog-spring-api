package br.com.blogapi.repository.author;

import org.springframework.data.repository.CrudRepository;

import br.com.blogapi.model.author.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
