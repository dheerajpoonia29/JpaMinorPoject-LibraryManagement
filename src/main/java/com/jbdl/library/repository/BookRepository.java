package com.jbdl.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbdl.library.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{

}
