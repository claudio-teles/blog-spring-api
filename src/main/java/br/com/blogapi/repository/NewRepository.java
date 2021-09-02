package br.com.blogapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blogapi.model.New;

public interface NewRepository extends JpaRepository<New, Long> {
	
	List<New> findByTitleContaining(String title);
	List<New> findAll();

}
