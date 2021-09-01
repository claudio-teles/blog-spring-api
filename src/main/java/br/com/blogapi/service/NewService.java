package br.com.blogapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.NewDAO;
import br.com.blogapi.model.New;

@Service
public class NewService {
	
	@Autowired
	private NewDAO newDAO;
	
	public New save(New _new) throws Exception {
		
		if ( (_new != null) && (_new.getAuthorName() != null) && (_new.getTitle() != null) && (_new.getContent() != null) ) {
			if (_new.getTitle().equals("")) {
				throw new Exception("Blank title exception");
			} else if (_new.getContent().equals("")) {
				throw new Exception("Blank content exception");
			}
			return newDAO.createNew(_new);
		}
		
		throw new NullPointerException();
		
	}
	
	public New find(Long idNew) { 
		
		if (newDAO.getNew(idNew).isPresent()) {
			return newDAO.getNew(idNew).get();
		}
		
		throw new NullPointerException();
	}
	
	public New find(String title) throws Exception {
		
		if (title != null ) {
			if (title.equals("")) {
				throw new Exception("Blank title exception");
			} else if (newDAO.getNew(title).isPresent()) {
				return newDAO.getNew(title).get();
			}
		}
		
		throw new NullPointerException();
	}
	
	public Page<New> listNewsWithPages(Integer topOfPage, Integer endOfPage) {
		
		if (topOfPage != null && endOfPage != null) {
			return newDAO.listAllNewsPageable(PageRequest.of(topOfPage, endOfPage));
		}
		
		throw new NullPointerException();
	}
	
	public Iterable<New> listAllNews() {
		return newDAO.listAllNews();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public New uptate(Long idNew, New _new) throws Exception {
		
		if (idNew != null && _new.getTitle() != null && _new.getContent() != null && _new.getAuthorName() != null) {
			if (_new.getTitle().equals("")) {
				throw new Exception("Blank title exception");
			}
			if (_new.getContent().equals("")) {
				throw new Exception("Blank content exception");
			}
			if (_new.getAuthorName().equals("")) {
				throw new Exception("Blank author exception");
			}
			New n = find(idNew);
			n.setTitle(_new.getTitle());
			n.setDateTime(_new.getDateTime());
			n.setContent(_new.getContent());
			n.setAuthorName(_new.getAuthorName());
			n.setComments(_new.getComments());
			n.setTags(_new.getTags());
			
			return save(n);
		}
		
		throw new NullPointerException();
	}
	
	public void delete(New _new) {
		if (_new != null) {
			newDAO.deleteNew(_new);
		}
	}

}
