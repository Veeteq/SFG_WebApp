package com.springframeworkguru.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.springframeworkguru.webapp.entity.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}
