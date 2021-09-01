package br.com.blogapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5312514817403129932L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTag;
	@Column(nullable = false, length = 20)
	private String value;

}
