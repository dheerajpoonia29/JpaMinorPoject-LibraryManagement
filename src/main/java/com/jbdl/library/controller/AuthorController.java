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
import com.jbdl.library.model.request.AuthorRequest;
import com.jbdl.library.model.response.AuthorResponse;
import com.jbdl.library.model.response.MainResponse;
import com.jbdl.library.model.response.Response;
import com.jbdl.library.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	AuthorService service;
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<>(
				new MainResponse("author api up", null), 
				HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody AuthorRequest req) {
		String msg = service.create(req);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<?> readAll() {
		List<AuthorEntity> entities = service.readAll();
		ArrayList<AuthorResponse> response =  new ArrayList<>();
		entities.forEach(entity -> {
			response.add(new AuthorResponse(
					entity.getId(),
					entity.getAge(),
					entity.getName(),
					entity.getCountry(),
					entity.getEmail()));
		});
		if(entities.isEmpty()) {
			return new ResponseEntity<>(
					new MainResponse("no author found", null), 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				entities, 
				HttpStatus.FOUND);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<?> readById(@PathVariable int id) {
		AuthorResponse response;
		try {
			AuthorEntity entity = service.readById(id);
			response = new AuthorResponse(
					entity.getId(),
					entity.getAge(),
					entity.getName(),
					entity.getCountry(),
					entity.getEmail());
		} catch (NullPointerException | java.util.NoSuchElementException e) {
			return new ResponseEntity<>(
					new MainResponse("Author not found", null), 
					HttpStatus.OK);
		}
		return new ResponseEntity<>(
				new MainResponse("Author found", response), 
				HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody AuthorRequest req) {
		String msg = service.update(req, id);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		String msg = service.delete(id);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.OK);
	}
}
