package br.com.blogapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.blogapi.enumeration.Gender;
import br.com.blogapi.model.Author;
import br.com.blogapi.model.Comment;
import br.com.blogapi.model.New;
import br.com.blogapi.model.Tag;
import br.com.blogapi.service.AuthorService;
import br.com.blogapi.service.CommentService;
import br.com.blogapi.service.NewService;
import br.com.blogapi.service.TagService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BlogSpringApiApplicationTests {
	
	@Autowired
	private AuthorService authorService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private NewService newService;
	@Autowired
	private TagService tagService;
	private List<Comment> comments = new ArrayList<>();
	private List<Tag> tags1 = new ArrayList<>();
	
	/**
	 * Testar a criação da entidade Author
	 */
	@Test
	@Order(1)
	void createAuthorTest() {
		try {
			assertEquals(1L, authorService.save(new Author(null, "Author 1", Gender.MALE)).getIdAuthor());
			assertEquals(2L, authorService.save(new Author(null, "Author 2", Gender.MALE)).getIdAuthor());
			assertEquals(3L, authorService.save(new Author(null, "Author 3", Gender.FEMALE)).getIdAuthor());
			assertEquals(4L, authorService.save(new Author(null, "Author 4", Gender.MALE)).getIdAuthor());
			assertEquals(5L, authorService.save(new Author(null, "Author 5", Gender.MALE)).getIdAuthor());
			assertEquals(6L, authorService.save(new Author(null, "Author 6", Gender.FEMALE)).getIdAuthor());
			assertEquals(7L, authorService.save(new Author(null, "Author 7", Gender.MALE)).getIdAuthor());
			assertEquals(8L, authorService.save(new Author(null, "Author 8", Gender.MALE)).getIdAuthor());
			assertEquals(9L, authorService.save(new Author(null, "Author 9", Gender.FEMALE)).getIdAuthor());
			assertEquals(10L, authorService.save(new Author(null, "Author 10", Gender.FEMALE)).getIdAuthor());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Testar a criação da entidade Comment
	 */
	@Test
	@Order(2)
	void createCommentTest() {
		try {
			Comment c1 = new Comment(null, "Content 1", 
						LocalDateTime.of(1999, Month.MARCH, 1, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
						authorService.loadAuthor(1L).get()
					);
			Comment c2 = new Comment(null, "Content 2", 
					LocalDateTime.of(2000, Month.APRIL, 2, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(3L).get()
					);
			Comment c3 = new Comment(null, "Content 3", 
					LocalDateTime.of(1995, Month.FEBRUARY, 10, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(5L).get()
					);
			Comment c4 = new Comment(null, "Content 4", 
					LocalDateTime.of(1999, Month.MARCH, 1, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(1L).get()
					);
			Comment c5 = new Comment(null, "Content 5", 
					LocalDateTime.of(1999, Month.MARCH, 1, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(5L).get()
					);
			Comment c6 = new Comment(null, "Content 6", 
					LocalDateTime.of(1999, Month.MARCH, 1, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(5L).get()
					);
			Comment c7 = new Comment(null, "Content 7", 
					LocalDateTime.of(2001, Month.OCTOBER, 16, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(1L).get()
					);
			Comment c8 = new Comment(null, "Content 8", 
					LocalDateTime.of(1999, Month.MARCH, 1, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(1L).get()
					);
			Comment c9 = new Comment(null, "Content 9", 
					LocalDateTime.of(1993, Month.AUGUST, 9, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(2L).get()
					);
			Comment c10 = new Comment(null, "Content 10", 
					LocalDateTime.of(1999, Month.DECEMBER, 21, LocalDateTime.now().getHour(), LocalDateTime.now().getMinute()), 
					authorService.loadAuthor(10L).get()
					);
			
			comments.add(c1);
			comments.add(c2);
			comments.add(c3);
			comments.add(c4);
			comments.add(c5);
			comments.add(c6);
			comments.add(c7);
			comments.add(c8);
			comments.add(c9);
			comments.add(c10);
			
			
			assertEquals(11L, commentService.save(c1).getIdComment());
			assertEquals(12L, commentService.save(c2).getIdComment());
			assertEquals(13L, commentService.save(c3).getIdComment());
			assertEquals(14L, commentService.save(c4).getIdComment());
			assertEquals(15L, commentService.save(c5).getIdComment());
			assertEquals(16L, commentService.save(c6).getIdComment());
			assertEquals(17L, commentService.save(c7).getIdComment());
			assertEquals(18L, commentService.save(c8).getIdComment());
			assertEquals(19L, commentService.save(c9).getIdComment());
			assertEquals(20L, commentService.save(c10).getIdComment());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Testar a criação da entidade New
	 * 
	 * @throws Exception
	 */
	@Test
	@Order(3)
	void createNewTest() throws Exception {
		comments.clear();
		comments.add(commentService.find(11L));
		comments.add(commentService.find(12L));
		comments.add(commentService.find(13L));
		comments.add(commentService.find(14L));
		comments.add(commentService.find(15L));
		comments.add(commentService.find(16L));
		comments.add(commentService.find(17L));
		comments.add(commentService.find(18L));
		comments.add(commentService.find(19L));
		comments.add(commentService.find(20L));
		
		Tag tag1 = new Tag(null, "#tag1");
		Tag tag2 = new Tag(null, "#tag2");
		Tag tag3 = new Tag(null, "#tag3");
		Tag tag4 = new Tag(null, "#tag4");
		Tag tag5 = new Tag(null, "#tag5");
		
		tagService.save(tag1);
		tagService.save(tag2);
		tagService.save(tag3);
		tagService.save(tag4);
		tagService.save(tag5);
		
		tags1.add(tagService.findTag(21L));
		tags1.add(tagService.findTag(24L));
		tags1.add(tagService.findTag(22L));
		tags1.add(tagService.findTag(23L));
		tags1.add(tagService.findTag(25L));
		
		
		New n1 = new New(
					null, "Title 1", LocalDateTime.of(1991, Month.APRIL, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 1", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n2 = new New(
					null, "Title 2", LocalDateTime.of(1995, Month.OCTOBER, 28, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 2", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n3 = new New(
					null, "Title 3", LocalDateTime.of(2000, Month.DECEMBER, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 3", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n4 = new New(
					null, "Title 4", LocalDateTime.of(2003, Month.FEBRUARY, 27, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 4", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n5 = new New(
					null, "Title 5", LocalDateTime.of(2000, Month.NOVEMBER, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 5", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n6 = new New(
					null, "Title 6", LocalDateTime.of(1999, Month.JANUARY, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 6", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n7 = new New(
					null, "Title 7", LocalDateTime.of(2003, Month.APRIL, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 7", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n8 = new New(
					null, "Title 8", LocalDateTime.of(1988, Month.JULY, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 8", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n9 = new New(
					null, "Title 9", LocalDateTime.of(1989, Month.MAY, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 9", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n10 = new New(
					null, "Title 10", LocalDateTime.of(2007, Month.APRIL, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 10", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n11 = new New(
					null, "Title 11", LocalDateTime.of(1991, Month.AUGUST, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 11", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n12 = new New(
					null, "Title 12", LocalDateTime.of(1991, Month.JUNE, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 12", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n13 = new New(
					null, "Title 13", LocalDateTime.of(1991, Month.MARCH, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 13", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n14 = new New(
					null, "Title 14", LocalDateTime.of(1991, Month.NOVEMBER, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 14", authorService.loadAuthor(1L).get(), comments, tags1
				);
		New n15 = new New(
					null, "Title 15", LocalDateTime.of(1991, Month.APRIL, 14, LocalDateTime.now().getDayOfMonth(), 
							LocalDateTime.now().getHour()), "New 15", authorService.loadAuthor(1L).get(), comments, tags1
				);
		
		assertEquals(26L, newService.save(n1).getIdNew());
		assertEquals(27L, newService.save(n2).getIdNew());
		assertEquals(28L, newService.save(n3).getIdNew());
		assertEquals(29L, newService.save(n4).getIdNew());
		assertEquals(30L, newService.save(n5).getIdNew());
		assertEquals(31L, newService.save(n6).getIdNew());
		assertEquals(32L, newService.save(n7).getIdNew());
		assertEquals(33L, newService.save(n8).getIdNew());
		assertEquals(34L, newService.save(n9).getIdNew());
		assertEquals(35L, newService.save(n10).getIdNew());
		assertEquals(36L, newService.save(n11).getIdNew());
		assertEquals(37L, newService.save(n12).getIdNew());
		assertEquals(38L, newService.save(n13).getIdNew());
		assertEquals(39L, newService.save(n14).getIdNew());
		assertEquals(40L, newService.save(n15).getIdNew());
	}
	
	/**
	 * Testar a obtenção de uma noticia pelo o id dela
	 */
	@Test
	@Order(4)
	void findNewById() {
		comments.clear();
		comments.add(commentService.find(11L));
		comments.add(commentService.find(12L));
		comments.add(commentService.find(13L));
		comments.add(commentService.find(14L));
		comments.add(commentService.find(15L));
		comments.add(commentService.find(16L));
		comments.add(commentService.find(17L));
		comments.add(commentService.find(18L));
		comments.add(commentService.find(19L));
		comments.add(commentService.find(20L));
		
		tags1.clear();	
		tags1.add(tagService.findTag(21L));
		tags1.add(tagService.findTag(24L));
		tags1.add(tagService.findTag(22L));
		tags1.add(tagService.findTag(23L));
		tags1.add(tagService.findTag(25L));
		
		New n1 = new New(
					26L, "Title 1", LocalDateTime.of(1991, Month.APRIL, 14, LocalDateTime.now().getDayOfMonth(), 
						LocalDateTime.now().getHour()), "New 1", authorService.loadAuthor(1L).get(), comments, tags1
				);
		assertEquals(n1, newService.find(26L));
	}
	
	/**
	 * Testar a pesquisa de uma noticia pelo o titulo dela, semelhante ao recurso LIKE das linguagens de SQL. ex: select n from New n where n.title like '%{termo de pesquisa}%'
	 */
	@Test
	@Order(5)
	void findNewsLikeTitle() {
		try {
			assertEquals(1, newService.find("Title 2").size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Testar a exibição de lista de noticias com uma quantidade específica de itens em cada página
	 * 
	 * De 0 até 4 temos 5 páginas com três noticias em cada página de um total de 15 noticias em todas as páginas;
	 * para mudar de página para outra, basta fazer assim: newService.listNewsWithPages(0, 3), newService.listNewsWithPages(1, 3), ... até newService.listNewsWithPages(4, 3)
	 */
	@Test
	@Order(6)
	void findNewsWithPages() {
		try {
			assertEquals(3, newService.listNewsWithPages(4, 3).getContent().size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Testar a obtenção da quantidade de noticias publicadas, o valor esperado é 15.
	 */
	@Test
	@Order(7)
	void listAllNew() {
		assertEquals(15, newService.listAllNews().size());
	}

}
