package br.com.blogapi.model;

import javax.persistence.Entity;

import br.com.blogapi.enumeration.Gender;

@Entity
public class Reader extends Author {

	public Reader() {
		super();
	}

	public Reader(Long idAuthor, String authorsName, Gender gender) {
		super(idAuthor, authorsName, gender);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -9014580110760658050L;

}
