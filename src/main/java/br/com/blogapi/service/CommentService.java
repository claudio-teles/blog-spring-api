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
	
	public Comment save(Comment comment) throws Exception {
		
		if (comment != null) {
			if (comment.getContent().equals("")) {
				throw new Exception("Blank content exception");
			}
			return commentDAO.createComment(comment);
		}
		throw new NullPointerException();
		
	}
	
	public Comment find(Long idCommment) {
		if (idCommment != null) {
			if (commentDAO.getId(idCommment).isPresent()) {
				return commentDAO.getId(idCommment).get();
			}
		}
		throw new NullPointerException();
	}

}
