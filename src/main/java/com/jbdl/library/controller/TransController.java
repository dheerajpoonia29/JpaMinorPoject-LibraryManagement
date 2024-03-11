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
import com.jbdl.library.entity.CardEntity;
import com.jbdl.library.entity.StudentEntity;
import com.jbdl.library.entity.TransEntity;
import com.jbdl.library.model.request.TransRequest;
import com.jbdl.library.model.response.AuthorResponse;
import com.jbdl.library.model.response.BookResponse;
import com.jbdl.library.model.response.CardResponse;
import com.jbdl.library.model.response.TransResponse;
import com.jbdl.library.model.response.MainResponse;
import com.jbdl.library.model.response.StudentResponse;
import com.jbdl.library.service.TransService;

@RestController
@RequestMapping("/trans")
public class TransController {
	@Autowired
	TransService service;
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<>(
				new MainResponse("book api up", null), 
				HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody TransRequest req) {
		String msg = service.create(req);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<?> readAll() {
		List<TransEntity> entities = service.readAll();
		ArrayList<TransResponse> response =  new ArrayList<>();
		entities.forEach(entity -> {
			BookEntity be = entity.getBook();
			AuthorEntity ae = be.getAuthor();
			AuthorResponse ar = new AuthorResponse(
					ae.getId(),
					ae.getAge(),
					ae.getName(),
					ae.getCountry(),
					ae.getEmail()
					);
			BookResponse bookResponse = new BookResponse(
					be.getId(),
					be.getName(),
					be.getTotalPage(),
					be.getLanguage(),
					be.getAvailable(),
					be.getGenre(),
					be.getIsbnNo(),
					be.getPublishedDate(),
					ar);
			
			CardEntity ce = entity.getCard();
			StudentEntity se = ce.getStudent();
			StudentResponse sr = new StudentResponse(
					se.getId(),
					se.getAge(),
					se.getName(),
					se.getCountry(),
					se.getEmail(),
					se.getPhoneNo(),
					se.getCreatedOn(),
					se.getUpdatedOn());
			CardResponse cardResponse = new CardResponse(
					ce.getId(),
					ce.getStatus(),
					ce.getEmail(),
					ce.getValidUpto(),
					ce.getCreatedOn(),
					ce.getUpdatedOn(),
					sr);
			
			
			response.add(new TransResponse(
					bookResponse,
					cardResponse,
					entity.getTransDate(),
					entity.getDueDate(),
					entity.isIssued(),
					entity.isReturned(),
					entity.getFineAmount(),
					entity.isStatus(),
					entity.getCreateOn(),
					entity.getUpdatedOn()
					));
		});
		if(entities.isEmpty()) {
			return new ResponseEntity<>(
					new MainResponse("no transaction found", null), 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				entities, 
				HttpStatus.FOUND);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<?> readById(@PathVariable int id) {
		TransResponse response;
		try {
			TransEntity entity = service.readById(id);
			
			BookEntity be = entity.getBook();
			AuthorEntity ae = be.getAuthor();
			AuthorResponse ar = new AuthorResponse(
					ae.getId(),
					ae.getAge(),
					ae.getName(),
					ae.getCountry(),
					ae.getEmail()
					);
			BookResponse bookResponse = new BookResponse(
					be.getId(),
					be.getName(),
					be.getTotalPage(),
					be.getLanguage(),
					be.getAvailable(),
					be.getGenre(),
					be.getIsbnNo(),
					be.getPublishedDate(),
					ar);
			
			
			CardEntity ce = entity.getCard();
			StudentEntity se = ce.getStudent();
			StudentResponse sr = new StudentResponse(
					se.getId(),
					se.getAge(),
					se.getName(),
					se.getCountry(),
					se.getEmail(),
					se.getPhoneNo(),
					se.getCreatedOn(),
					se.getUpdatedOn());
			CardResponse cardResponse = new CardResponse(
					ce.getId(),
					ce.getStatus(),
					ce.getEmail(),
					ce.getValidUpto(),
					ce.getCreatedOn(),
					ce.getUpdatedOn(),
					sr);
			
			
			response = new TransResponse(
					bookResponse,
					cardResponse,
					entity.getTransDate(),
					entity.getDueDate(),
					entity.isIssued(),
					entity.isReturned(),
					entity.getFineAmount(),
					entity.isStatus(),
					entity.getCreateOn(),
					entity.getUpdatedOn());
			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (NullPointerException | java.util.NoSuchElementException e) {
			return new ResponseEntity<>(
					new MainResponse("transaction not found", null), 
					HttpStatus.OK);
		}
	}
		
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody TransRequest req) {
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
