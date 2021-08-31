package br.com.blogapi.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.author.AuthorDAO;
import br.com.blogapi.model.author.Author;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorDAO authorDAO;
	
	public Author save(Author author) throws Exception {
		if ((author.getAuthorsName() != null)) {
			if ((author.getAuthorsName().equals(""))) {
				throw new Exception("Blank author name exception");
			} else {
				return authorDAO.createAuthor(author);
			}
		} else {
			throw new NullPointerException();
		}
	}

}
