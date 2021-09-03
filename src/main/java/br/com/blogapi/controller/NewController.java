package br.com.blogapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.blogapi.model.New;
import br.com.blogapi.service.NewService;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NewController {
	
	@Autowired
	private NewService newService;
	
	@PostMapping("/new")
	@ResponseStatus(HttpStatus.CREATED)
	@ExceptionHandler
	@ApiOperation(value = "Register a news.")
	public New postNews(@RequestBody New _new) throws Exception {
		return newService.save(_new);
	}
	
	@GetMapping("/new/{idNew}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find new by id.")
	public New getNew(@PathVariable("idNew") Long idNew) {
		return newService.find(idNew);
	}
	
	@GetMapping("/new")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find new by title.")
	public List<New> getNew(@RequestParam(name = "title") String title) throws Exception {
		return newService.find(title);
	}
	
	@GetMapping("/new/pages")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Find list of news using pagination.")
	public List<New> getNew(@RequestParam(name = "topOfPage") int topOfPage, @RequestParam(name = "endOfPage") int endOfPage) throws Exception {
		return newService.listNewsWithPages(topOfPage, endOfPage);
	}
	
	@PutMapping("/new")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Update a news.")
	public New updateNews(@RequestBody New _new) throws Exception {
		return newService.save(_new);
	}
	
	@PutMapping("/new/comment")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Add new comment.")
	public New addNewComment(@RequestBody New _new) throws Exception {
		return newService.save(_new);
	}
	
	@DeleteMapping("/new/{idNew}")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Delete new by id of new.")
	public void deleteNew(@PathVariable("idNew") Long idNew) throws Exception {
		newService.delete(newService.find(idNew));
	}

}
