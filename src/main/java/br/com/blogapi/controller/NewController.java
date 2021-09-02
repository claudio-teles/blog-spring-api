package br.com.blogapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@ApiOperation(value = "Register a news.")
	public New postNews(@RequestBody New _new) throws Exception {
		return newService.save(_new);
	}

}
