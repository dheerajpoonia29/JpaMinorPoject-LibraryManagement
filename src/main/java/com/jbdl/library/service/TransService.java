package com.jbdl.library.service;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbdl.library.entity.BookEntity;
import com.jbdl.library.entity.CardEntity;
import com.jbdl.library.entity.TransEntity;
import com.jbdl.library.model.request.TransRequest;
import com.jbdl.library.repository.TransRepository;

@Service
public class TransService {
	@Autowired
	TransRepository tr;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	CardService cardService;
	
	public String test() {
		return "transaction api is working";
	}
	
	public String create(TransRequest detail) {
		try {
			BookEntity bookEntity;
			CardEntity cardEntity;
			try {
				bookEntity = bookService.readById(detail.getBookId());
			} catch(NoSuchElementException e) {
				return "book not found";
			}
			try {
				cardEntity = cardService.readById(detail.getCardId());
			} catch(NoSuchElementException e) {
				return "card not found";
			}
			TransEntity entity = new TransEntity(
					0,
					bookEntity,
					cardEntity,
					new Date(),
					detail.getDueDate(),
					false,
					false,
					0,
					false,
					new Date(),
					null);
			tr.save(entity);
			return "transaction created";
		} catch(Exception e) {
			return "transaction not created, exception: "+e.getMessage();
		}
	}

	public List<TransEntity> readAll() {
		List<TransEntity> entities = tr.findAll();
		return entities;
	}

	public TransEntity readById(int id) throws java.util.NoSuchElementException {
		return tr.findById(id).get();
	}

	public String update(TransRequest detail, int id) {
		TransEntity entity = readById(id);
		if(entity==null) {
			return "transaction not found";
		}
		entity.setFineAmount(detail.getFineAmount()!=0?detail.getFineAmount():entity.getFineAmount());
		entity.setDueDate(detail.getDueDate()!=null?detail.getDueDate():entity.getDueDate());
		entity.setReturned(detail.isReturned()?detail.isReturned():entity.isIssued());
		entity.setUpdatedOn(new Date());
		tr.save(entity);
		return "transaction updated";
	}
	
	public String delete(int id) {
		TransEntity entity = readById(id);
		if(entity==null) {
			return "transaction not found";
		}
		tr.delete(entity);
		return "transaction deleted";
	}
}
