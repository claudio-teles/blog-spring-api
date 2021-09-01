package br.com.blogapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.AuthorDAO;
import br.com.blogapi.model.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorDAO authorDAO;
	
	public Author save(Author author) throws Exception {
		if ((author.getAuthorsName() != null)) {
			if ((author.getAuthorsName().equals(""))) {
				throw new Exception("Blank author exception");
			} else {
				return authorDAO.createAuthor(author);
			}
		} else {
			throw new NullPointerException();
		}
	}
	
	public Optional<Author> loadAuthor(Long idAuthor) {
		if (idAuthor != null) {
			return authorDAO.getId(idAuthor);
		} else {
			return null;
		}
	}

}
