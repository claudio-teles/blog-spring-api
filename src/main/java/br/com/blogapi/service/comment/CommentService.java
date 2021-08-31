/**
 * 
 */
package br.com.blogapi.service.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.comment.CommentDAO;
import br.com.blogapi.model.comment.Comment;

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
			if (comment.getAuthorsName() == null) {
				throw new Exception("Absent author exception");
			} else {
				return commentDAO.createComment(comment);
			}
		} else {
			throw new NullPointerException();
		}
	}

}
