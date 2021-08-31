package br.com.blogapi.repository.news;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.blogapi.model.news.New;

public interface NewPaginationRepository extends PagingAndSortingRepository<New, Long> {
	
	Page<New> findAllOrderByIdAsc(Pageable pageable);
	
}
