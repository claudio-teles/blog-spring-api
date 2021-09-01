package br.com.blogapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.blogapi.enumeration.Gender;
import br.com.blogapi.model.Author;
import br.com.blogapi.model.Comment;
import br.com.blogapi.service.AuthorService;
import br.com.blogapi.service.CommentService;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class BlogSpringApiApplicationTests {
	
	@Autowired
	private AuthorService authorService;
	@Autowired
	private CommentService commentService;
	
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
	
	

}
