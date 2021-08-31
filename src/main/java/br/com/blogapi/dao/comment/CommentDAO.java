package br.com.blogapi.dao.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.blogapi.model.comment.Comment;
import br.com.blogapi.repository.comment.CommentRepository;

@Repository
public class CommentDAO {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}

}
