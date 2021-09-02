package br.com.blogapi.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.blogapi.model.Tag;
import br.com.blogapi.repository.TagRepository;

@Repository
public class TagDAO {
	
	@Autowired
	private TagRepository tagRepository;
	
	public Tag create(Tag tag) {
		return tagRepository.save(tag);
	}
	
	public Optional<Tag> load(Long idTag) {
		return tagRepository.findById(idTag);
	}

}
