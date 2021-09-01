package br.com.blogapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blogapi.model.New;

public interface NewRepository extends JpaRepository<New, Long> {
	
	Optional<New> findByTitle(String title);
	List<New> findAllOrderByIdAsc();

}
