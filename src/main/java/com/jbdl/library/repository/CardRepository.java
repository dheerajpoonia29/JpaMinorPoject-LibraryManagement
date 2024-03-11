package com.jbdl.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbdl.library.entity.CardEntity;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Integer>{

}
