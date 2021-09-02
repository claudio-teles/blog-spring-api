package br.com.blogapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomePageController {
	
	@AllArgsConstructor
	@Data
	public class Welcome {
		private String message;
	}
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Home Page")
	public Welcome sayWelcome() {
		return new Welcome("Welcome!");
	}

}
