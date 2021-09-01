package br.com.blogapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.TagDAO;
import br.com.blogapi.model.Tag;

@Service
public class TagService {
	
	@Autowired
	private TagDAO tagDAO;
	
	public Tag save(Tag tag) throws Exception {
		if (tag != null) {
			if (tag.getValue().equals("")) {
				throw new Exception("Blank tag exception");
			}
			return tagDAO.create(tag);
		}
		throw new NullPointerException();
	}

}
