package br.com.blogapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.blogapi.model.Author;
import br.com.blogapi.repository.AuthorRepository;

@Repository
public class AuthorDAO {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

}
