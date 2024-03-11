package com.jbdl.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbdl.library.entity.CardEntity;
import com.jbdl.library.entity.StudentEntity;
import com.jbdl.library.model.request.CardRequest;
import com.jbdl.library.repository.CardRepository;

@Service
public class CardService {
	@Autowired
	CardRepository cr;
	
	@Autowired
	StudentService studentService;
	
	public String create(CardRequest detail) {
		StudentEntity studentEntity = studentService.readById(detail.getStudentId());
		if(studentEntity==null || studentEntity.getId()==0) {
			System.out.println("Student not found");
			return "Card not created, request student not found";
		} else {
			Date validUpto = new Date();
			validUpto.setMonth((new Date()).getMonth()+1);
			CardEntity entity = new CardEntity(
					detail.getStatus(), 
					studentEntity.getEmail(), 
					validUpto,
					new Date(),
					null,
					studentEntity);
			cr.save(entity);
			return "Card created";
		}
	}

	public List<CardEntity> readAll() {
		List<CardEntity> entities = cr.findAll();
		return entities;
	}

	public CardEntity readById(int id) throws java.util.NoSuchElementException {
		return cr.findById(id).get();
	}

	public String update(CardRequest detail, int id) {
		CardEntity entity = readById(id);
		if(entity==null) {
			return "Card not found";
		}
		entity.setStatus(detail.getStatus()!=entity.getStatus()?detail.getStatus():entity.getStatus());
		entity.setValidUpto(detail.getValidUpto()==null?entity.getValidUpto():detail.getValidUpto());
		entity.setUpdatedOn(new Date());
		cr.save(entity);
		return "Card updated";
	}
	
	public String delete(int id) {
		CardEntity entity = readById(id);
		if(entity==null) {
			return "Card not found";
		}
		cr.delete(entity);
		return "Card deleted";
	}
}