/**
 * 
 */
package br.com.blogapi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.blogapi.enumeration.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claudio
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8568870148278712316L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idAuthor;
	@Column(nullable = false, length = 20)
	private String authorsName;
	private Gender gender;

}