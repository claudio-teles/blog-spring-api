package br.com.blogapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.blogapi.model.Comment;
import br.com.blogapi.repository.CommentRepository;

@Repository
public class CommentDAO {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public Optional<Comment> getId(Long idComment) {
		return commentRepository.findById(idComment);
	}

}
