package com.jbdl.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbdl.library.entity.AuthorEntity;
import com.jbdl.library.model.request.AuthorRequest;
import com.jbdl.library.repository.AuthorRepository;

@Service
public class AuthorService {
	@Autowired
	AuthorRepository ar;
	
	public String create(AuthorRequest detail) {
		AuthorEntity entity = new AuthorEntity(
				0,
				detail.getAge(), 
				detail.getName(), 
				detail.getEmail(),
				detail.getCountry());
		ar.save(entity);
		return "Author created";
	}

	public List<AuthorEntity> readAll() {
		List<AuthorEntity> entities = ar.findAll();
		return entities;
	}

	public AuthorEntity readById(int id) {
		return ar.findById(id).get();
	}

	public String update(AuthorRequest detail, int id) {
		AuthorEntity entity = readById(id);
		if(entity==null) {
			return "Author not found";
		}
		entity.setAge(detail.getAge()==0?entity.getAge():detail.getAge());
		entity.setName(detail.getName()==null?entity.getName():detail.getName());
		entity.setCountry(detail.getCountry()==null?entity.getCountry():detail.getCountry());
		entity.setEmail(detail.getEmail()==null?entity.getEmail():detail.getEmail());
		ar.save(entity);
		return "Author updated";
	}
	
	public String delete(int id) {
		AuthorEntity entity = readById(id);
		if(entity==null) {
			return "Author not found";
		}
		ar.delete(entity);
		return "Author deleted";
	}
}