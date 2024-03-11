package com.jbdl.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
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

import com.jbdl.library.entity.CardEntity;
import com.jbdl.library.entity.StudentEntity;
import com.jbdl.library.model.request.CardRequest;
import com.jbdl.library.model.response.CardResponse;
import com.jbdl.library.model.response.MainResponse;
import com.jbdl.library.model.response.StudentResponse;
import com.jbdl.library.service.CardService;

@RestController
@RequestMapping("/card")
public class CardController {
	@Autowired
	CardService service;
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<>(
				new MainResponse("card api up", null), 
				HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody CardRequest req) {
		String msg = service.create(req);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<?> readAll() {
		List<CardEntity> entities = service.readAll();
		ArrayList<CardResponse> response =  new ArrayList<>();
		entities.forEach(cardEntity -> {
			StudentEntity studentEntity = cardEntity.getStudent();
			StudentResponse studentResponse = new StudentResponse(
					studentEntity.getId(),
					studentEntity.getAge(),
					studentEntity.getName(),
					studentEntity.getCountry(),
					studentEntity.getEmail(),
					studentEntity.getPhoneNo(),
					studentEntity.getCreatedOn(),
					studentEntity.getUpdatedOn());
			response.add(new CardResponse(
					cardEntity.getId(),
					cardEntity.getStatus(),
					cardEntity.getEmail(),
					cardEntity.getValidUpto(),
					cardEntity.getCreatedOn(),
					cardEntity.getUpdatedOn(),
					studentResponse));
		});
		if(entities.isEmpty()) {
			return new ResponseEntity<>(
					new MainResponse("no card found", null), 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				entities, 
				HttpStatus.FOUND);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<?> readById(@PathVariable int id) {
		CardResponse response;
		try {
			CardEntity cardEntity = service.readById(id);
			StudentEntity studentEntity = cardEntity.getStudent();
			StudentResponse studentResponse = new StudentResponse(
					studentEntity.getId(),
					studentEntity.getAge(),
					studentEntity.getName(),
					studentEntity.getCountry(),
					studentEntity.getEmail(),
					studentEntity.getPhoneNo(),
					studentEntity.getCreatedOn(),
					studentEntity.getUpdatedOn());
			response = new CardResponse(
					cardEntity.getId(),
					cardEntity.getStatus(),
					cardEntity.getEmail(),
					cardEntity.getValidUpto(),
					cardEntity.getCreatedOn(),
					cardEntity.getUpdatedOn(),
					studentResponse);
		} catch (NullPointerException | java.util.NoSuchElementException e) {
			return new ResponseEntity<>(
					new MainResponse("card not found", null), 
					HttpStatus.OK);
		}
		return new ResponseEntity<>(
				new MainResponse("card found", response), 
				HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody CardRequest req) {
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
