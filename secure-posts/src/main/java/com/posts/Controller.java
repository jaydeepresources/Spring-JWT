package com.posts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/all")
	public Post getPosts() {

		return new Post(1,"Hey","Success !");
	}

}