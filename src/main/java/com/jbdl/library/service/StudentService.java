package com.jbdl.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbdl.library.entity.StudentEntity;
import com.jbdl.library.model.request.StudentRequest;
import com.jbdl.library.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository sr;
	
	public String create(StudentRequest detail) {
		System.out.println("detail: "+detail);
		StudentEntity entity = new StudentEntity(
				detail.getAge(), 
				detail.getName(), 
				detail.getCountry(), 
				detail.getEmail(),
				detail.getPhoneNo(), 
				new Date(),
				null);
		System.out.println("entity: "+entity);
		sr.save(entity);
		return "Student created";
	}

	public List<StudentEntity> readAll() {
		return sr.findAll();
	}

	public StudentEntity readById(int id) throws java.util.NoSuchElementException {
		return sr.findById(id).get();
	}

	public String update(StudentRequest detail, int id) {
		StudentEntity entity = readById(id);
		if(entity==null) {
			return "Student not found";
		}
		entity.setAge(detail.getAge()==0?entity.getAge():detail.getAge());
		entity.setName(detail.getName()==null?entity.getName():detail.getName());
		entity.setCountry(detail.getCountry()==null?entity.getCountry():detail.getCountry());
		entity.setEmail(detail.getEmail()==null?entity.getEmail():detail.getEmail());
		entity.setPhoneNo(detail.getPhoneNo()==0?entity.getPhoneNo():detail.getPhoneNo());
		entity.setUpdatedOn(new Date());
//		entity.setStudentCard(detail.getCard()==null?entity.getStudentCard():detail.getCard());
		System.out.println(entity.toString());
		sr.save(entity);
		return "Student updated";
	}
	
	public String delete(int id) {
		StudentEntity entity = readById(id);
		if(entity==null) {
			return "Student not found";
		}
		sr.delete(entity);
		return "Student deleted";
	}
}
