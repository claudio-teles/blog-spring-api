 	/**
 * 
 */
package br.com.blogapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	@Column(nullable = false, length = 80)
	private String title;
	private LocalDateTime dateTime;
	@Column(nullable = false, length = 3000)
	private String content;
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(nullable = false)
	private Author authorName;
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Comment> comments;
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Tag> tags;

}
