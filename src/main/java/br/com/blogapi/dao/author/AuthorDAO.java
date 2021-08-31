package br.com.blogapi.dao.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.blogapi.model.author.Author;
import br.com.blogapi.repository.author.AuthorRepository;

@Repository
public class AuthorDAO {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author createAuthor(Author author) {
		return authorRepository.save(author);
	}

}
