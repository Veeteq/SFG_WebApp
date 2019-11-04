package com.springframeworkguru.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.springframeworkguru.webapp.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
