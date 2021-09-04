package br.com.blogapi.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blogapi.dao.NewDAO;
import br.com.blogapi.model.New;

@Service
public class QueryService {
	
	@Autowired
	private NewDAO newDAO;
	
	public Collection<New> findNews(String parameters) {
		Set<New> news = new HashSet<>();
		listAllNew()
			.forEach(n -> {
				n.getTags().forEach(t -> {
					Arrays.asList(parameters.split(","))
						.stream()
						.filter(tagString -> t.getValue().equals(tagString))
						.forEach(tagString -> {
							if (!news.contains(n)) {
								news.add(n);
							}
						});
				});
			});
		return news;
	}
	
	public List<New> listAllNew() {
		return newDAO.listAllNews();
	}

}
