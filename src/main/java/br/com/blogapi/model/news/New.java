 	/**
 * 
 */
package br.com.blogapi.model.news;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
public class New implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6429736914405226799L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idNew;
	@Column(length = 80)
	private String title;
	private LocalDateTime dateTime;
	@Column(length = 3000)
	private String content;
	@OneToOne
	private Author authorName;
	@ElementCollection
	private List<String> tags;

}
