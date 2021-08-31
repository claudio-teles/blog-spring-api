package br.com.blogapi.repository.news;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.blogapi.model.news.New;

public interface NewRepository extends JpaRepository<New, Long> {
	
	Boolean existsByTitle(String title);
	Optional<New> findByTitle(String title);
	List<New> findAllOrderByIdAsc();

}
