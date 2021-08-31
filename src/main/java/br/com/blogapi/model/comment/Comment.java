/**
 * 
 */
package br.com.blogapi.model.comment;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.blogapi.model.author.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author claudio
 *
 */
@NoArgsConstructor
@Data
@Entity
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2359211648111079874L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idComment;
	@Column(nullable = false, length = 3000)
	private String content;
	private LocalDateTime date;
	@Column(nullable = false, length = 20)
	private Author authorsName;

}
