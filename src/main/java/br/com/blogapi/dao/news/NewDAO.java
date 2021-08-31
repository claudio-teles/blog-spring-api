package br.com.blogapi.dao.news;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.blogapi.model.news.New;
import br.com.blogapi.repository.news.NewPaginationRepository;
import br.com.blogapi.repository.news.NewRepository;

@Repository
public class NewDAO {
	
	@Autowired
	private NewRepository newRepository;
	@Autowired
	private NewPaginationRepository newPaginationRepository;
	
	public New createNew(New _new) {
		return newRepository.save(_new);
	}
	
	public Optional<New> getNew(Long idNew) {
		return newRepository.findById(idNew);
	}
	
	public Boolean existNew(String title) {
		return newRepository.existsByTitle(title);
	}
	
	public Page<New> listAllNewsPageable(Pageable pageable) {
		return newPaginationRepository.findAllOrderByIdAsc(pageable);
	}
	
	public Iterable<New> listAllNews() {
		return newRepository.findAllOrderByIdAsc();
	}
	
	public Optional<New> getNew(String title) {
		return newRepository.findByTitle(title);
	}

}
