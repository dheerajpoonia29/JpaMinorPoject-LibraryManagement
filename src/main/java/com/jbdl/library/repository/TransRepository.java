package com.jbdl.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jbdl.library.entity.TransEntity;

@Repository
public interface TransRepository extends JpaRepository<TransEntity, Integer> {

}
