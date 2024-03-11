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

import com.jbdl.library.entity.CardEntity;
import com.jbdl.library.entity.StudentEntity;
import com.jbdl.library.model.request.CardRequest;
import com.jbdl.library.model.request.StudentRequest;
import com.jbdl.library.model.response.CardResponse;
import com.jbdl.library.model.response.MainResponse;
import com.jbdl.library.model.response.StudentResponse;
import com.jbdl.library.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService service;
	
	@GetMapping("/test")
	public ResponseEntity<?> test() {
		return new ResponseEntity<>(
				new MainResponse("student api up", null), 
				HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody StudentRequest req) {
		String msg = service.create(req);
		return new ResponseEntity<>(
				new MainResponse(msg, null), 
				HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<?> readAll() {
		List<StudentEntity> entities = service.readAll();
		ArrayList<StudentResponse> response =  new ArrayList<>();
		entities.forEach(entity -> {
			response.add(new StudentResponse(
					entity.getId(),
					entity.getAge(),
					entity.getName(),
					entity.getCountry(),
					entity.getEmail(),
					entity.getPhoneNo(),
					entity.getCreatedOn(),
					entity.getUpdatedOn()));
		});
		if(entities.isEmpty()) {
			return new ResponseEntity<>(
					new MainResponse("no student found", null), 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				entities, 
				HttpStatus.FOUND);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<?> readById(@PathVariable int id) {
		StudentResponse response;
		try {
			StudentEntity entity = service.readById(id);
			response = new StudentResponse(
					entity.getId(),
					entity.getAge(),
					entity.getName(),
					entity.getCountry(),
					entity.getEmail(),
					entity.getPhoneNo(),
					entity.getCreatedOn(),
					entity.getUpdatedOn());
//			CardEntity ce = entity.getStudentCard();
//			CardResponse cr = new CardResponse(
//							ce.getId(),
//							ce.getStatus(),
//							ce.getEmail(),
//							ce.getValidUpto(),
//							ce.getCreatedOn(),
//							ce.getUpdatedOn(),
//							response);
//			response.setCard(cr);
		} catch (NullPointerException | java.util.NoSuchElementException e) {
			return new ResponseEntity<>(
					new MainResponse("student not found", null), 
					HttpStatus.OK);
		}
		return new ResponseEntity<>(
				new MainResponse("student found", response), 
				HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable int id, @RequestBody StudentRequest req) {
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
