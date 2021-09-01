/**
 * 
 */
package br.com.blogapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.CommentDAO;
import br.com.blogapi.model.Comment;

/**
 * @author claudio
 *
 */
@Service
public class CommentService {
	
	@Autowired
	private CommentDAO commentDAO;
	
	@SuppressWarnings("unlikely-arg-type")
	public Comment save(Comment comment) throws Exception {
		
		if (comment != null) {
			if (comment.getAuthorsName().equals("")) {
				throw new Exception("Blank author exception");
			}
			if (comment.getContent().equals("")) {
				throw new Exception("Blank content exception");
			}
			commentDAO.createComment(comment);
		}
		
		throw new NullPointerException();
	}

}
