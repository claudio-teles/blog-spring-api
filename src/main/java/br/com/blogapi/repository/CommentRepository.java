package br.com.blogapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.blogapi.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

}
