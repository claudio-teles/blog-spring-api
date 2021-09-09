package br.com.blogapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.AuthorDAO;
import br.com.blogapi.dao.CommentDAO;
import br.com.blogapi.dao.NewDAO;
import br.com.blogapi.dao.TagDAO;
import br.com.blogapi.model.Comment;
import br.com.blogapi.model.New;
import br.com.blogapi.model.Tag;

@Service
public class NewService {
	
	@Autowired
	private AuthorDAO authorDao;
	
	@Autowired
	private TagDAO tagDao;
	
	@Autowired
	private CommentDAO commentDao;
	
	@Autowired
	private NewDAO newDAO;
	
	public New save(New _new) throws Exception {
		
		if ( (_new != null) && (_new.getAuthorName() != null) && (_new.getTitle() != null) && (_new.getContent() != null) ) {
			if (_new.getTitle().equals("")) {
				throw new Exception("Blank title exception");
			} else if (_new.getContent().equals("")) {
				throw new Exception("Blank content exception");
			}
			
			List<Tag> tags = new ArrayList<>();
			_new.getTags().forEach(t -> {
				tags.add(tagDao.create(t));// Salvar instancia de objeto transiente não salvo
			});
			
			List<Comment> comments = new ArrayList<>();
			_new.getComments().forEach(c -> {
				c.setAuthor(authorDao.createAuthor(c.getAuthor()));
				comments.add(commentDao.createComment(c));// Salvar instancia de objeto transiente não salvo
			});
			
			_new.setAuthorName(authorDao.createAuthor(_new.getAuthorName()));// Salvar instancia de objeto transiente não salvo
			
			_new.setTags(tags);
			_new.setComments(comments);
			
			
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
	
	public List<New> find(String title) throws Exception {
		
		if (title != null ) {
			if (title.equals("")) {
				throw new Exception("Blank title exception");
			}
			return newDAO.getNew(title);
		}
		
		throw new NullPointerException();
	}
	
	public List<New> listNewsWithPages(Integer topOfPage, Integer endOfPage) {
		
		if (topOfPage != null && endOfPage != null) {
			return newDAO.listAllNewsPageable(PageRequest.of(topOfPage, endOfPage)).getContent();
		}
		
		throw new NullPointerException();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public New uptate(New _new) throws Exception {
		
		if (_new.getIdNew() != null && _new.getTitle() != null && _new.getContent() != null && _new.getAuthorName() != null) {
			if (_new.getTitle().equals("")) {
				throw new Exception("Blank title exception");
			}
			if (_new.getContent().equals("")) {
				throw new Exception("Blank content exception");
			}
			if (_new.getAuthorName().equals("")) {
				throw new Exception("Blank author exception");
			}
			
			//Author a = authorDao.createAuthor(_new.getAuthorName());
			
			New n = find(_new.getIdNew());
			
			n.setTitle(_new.getTitle());
			n.setDateTime(_new.getDateTime());
			n.setContent(_new.getContent());
			n.setAuthorName(authorDao.createAuthor(_new.getAuthorName()));
			List<Comment> cms = new ArrayList<>();
			_new.getComments().forEach(cm -> {cms.add(commentDao.createComment(cm));});
			n.setComments(cms);
			List<Tag> tags = new ArrayList<>();
			_new.getTags().forEach(t -> {tags.add(tagDao.create(t));});
			n.setTags(tags);
			
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
