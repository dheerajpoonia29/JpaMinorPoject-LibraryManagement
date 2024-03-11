package com.jbdl.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbdl.library.entity.AuthorEntity;
import com.jbdl.library.entity.BookEntity;
import com.jbdl.library.model.request.BookRequest;
import com.jbdl.library.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	BookRepository br;
	
	@Autowired
	AuthorService authorService;
	
	public String create(BookRequest detail) {
		try {
			AuthorEntity authorEntity = authorService.readById(detail.getAuthorId());
			BookEntity entity = new BookEntity(
					0,
					detail.getName(),
					detail.getTotalPage(),
					detail.getLanguage(),
					detail.getAvailable(),
					detail.getGenre(),
					detail.getIsbnNo(),
					detail.getPublishedDate(),
					authorEntity);
			br.save(entity);
			return "Book created";
		} catch(Exception e) {
			return "author not exist, book not created, exception: "+e.getMessage();
		}
	}

	public List<BookEntity> readAll() {
		List<BookEntity> entities = br.findAll();
		return entities;
	}

	public BookEntity readById(int id) throws java.util.NoSuchElementException {
		return br.findById(id).get();
	}

	public String update(BookRequest detail, int id) {
		BookEntity entity = readById(id);
		if(entity==null) {
			return "Book not found";
		}
		entity.setAvailable(detail.getAvailable()?detail.getAvailable():entity.getAvailable());
		entity.setName(detail.getName()!=null?detail.getName():entity.getName());
		entity.setGenre(detail.getGenre()!=null?detail.getGenre():entity.getGenre());
		entity.setLanguage(detail.getLanguage()!=null?detail.getLanguage():entity.getLanguage());
		br.save(entity);
		return "Book updated";
	}
	
	public String delete(int id) {
		BookEntity entity = readById(id);
		if(entity==null) {
			return "Book not found";
		}
		br.delete(entity);
		return "Book deleted";
	}
}