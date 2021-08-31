package br.com.blogapi.repository.comment;

import org.springframework.data.repository.CrudRepository;

import br.com.blogapi.model.comment.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
