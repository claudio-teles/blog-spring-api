package br.com.blogapi.service.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.news.NewDAO;
import br.com.blogapi.model.news.New;

@Service
public class NewService {
	
	@Autowired
	private NewDAO newDAO;
	
	public New save(New _new) throws Exception {
		
		if ( (_new != null) && (_new.getAuthorName() != null) && (_new.getTitle() != null) && (_new.getContent() != null) ) {
			if (_new.getTitle().equals("")) {
				throw new Exception("Blank title execution");
			} else if (_new.getContent().equals("")) {
				throw new Exception("Blank content exception");
			}
			return newDAO.createNew(_new);
		} else {
			throw new NullPointerException();
		}
		
	}
	
	public New find(Long idNew) { 
		
		if (newDAO.getNew(idNew).isPresent()) {
			return newDAO.getNew(idNew).get();
		} else {
			throw new NullPointerException();
		}
		
	}
	
	public New find(String title) throws Exception {
		
		if (title != null ) {
			if (title.equals("")) {
				throw new Exception("Blank title execution");
			} else if (newDAO.existNew(title)) {
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

}
