/**
 * 
 */
package br.com.blogapi.model.author;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claudio
 *
 */
@NoArgsConstructor
@Data
@Entity
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8568870148278712316L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAuthor;
	@Column(length = 20)
	private String authorsName;

}
