package com.jbdl.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbdl.library.entity.AuthorEntity;
import com.jbdl.library.entity.BookEntity;
import com.jbdl.library.model.request.AuthorRequest;
import com.jbdl.library.model.request.BookRequest;
import com.jbdl.library.model.response.AuthorResponse;
import com.jbdl.library.model.response.BookResponse;
import com.jbdl.library.model.response.MainResponse;
import com.jbdl.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService service;
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<>(
				new MainResponse("book api up", null), 
				HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody BookRequest req) {
		String msg = service.create(req);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<?> readAll() {
		List<BookEntity> entities = service.readAll();
		ArrayList<BookResponse> response =  new ArrayList<>();
		entities.forEach(entity -> {
			AuthorEntity ae = entity.getAuthor();
			AuthorResponse authorResponse = new AuthorResponse(
					ae.getId(),
					ae.getAge(),
					ae.getName(),
					ae.getCountry(),
					ae.getEmail()
					);
			response.add(new BookResponse(
					entity.getId(),
					entity.getName(),
					entity.getTotalPage(),
					entity.getLanguage(),
					entity.getAvailable(),
					entity.getGenre(),
					entity.getIsbnNo(),
					entity.getPublishedDate(),
					authorResponse));
		});
		if(entities.isEmpty()) {
			return new ResponseEntity<>(
					new MainResponse("no book found", null), 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				entities, 
				HttpStatus.FOUND);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<?> readById(@PathVariable int id) {
		BookResponse response;
		try {
			BookEntity entity = service.readById(id);
			AuthorEntity ae = entity.getAuthor();
			AuthorResponse authorResponse = new AuthorResponse(
					ae.getId(),
					ae.getAge(),
					ae.getName(),
					ae.getCountry(),
					ae.getEmail()
					);
			response = new BookResponse(
					entity.getId(),
					entity.getName(),
					entity.getTotalPage(),
					entity.getLanguage(),
					entity.getAvailable(),
					entity.getGenre(),
					entity.getIsbnNo(),
					entity.getPublishedDate(),
					authorResponse);
		} catch (NullPointerException | java.util.NoSuchElementException e) {
			return new ResponseEntity<>(
					new MainResponse("Book not found", null), 
					HttpStatus.OK);
		}
		return new ResponseEntity<>(
				new MainResponse("Book found", response), 
				HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody BookRequest req) {
		String msg = service.update(req, id);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		String msg =  service.delete(id);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.OK);
	}
}
