/**
 * 
 */
package br.com.blogapi.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	@OneToOne
	@JoinColumn(nullable = false)
	private Author author;

}
