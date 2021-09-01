package br.com.blogapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.blogapi.model.New;
import br.com.blogapi.repository.NewPaginationRepository;
import br.com.blogapi.repository.NewRepository;

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
	
	public Page<New> listAllNewsPageable(Pageable pageable) {
		return newPaginationRepository.findAll(pageable);
	}
	
	public Iterable<New> listAllNews() {
		return newRepository.findAll();
	}
	
	public Optional<New> getNew(String title) {
		return newRepository.findByTitle(title);
	}
	
	public void deleteNew(New _new) {
		newRepository.delete(_new);
	}
	
}
