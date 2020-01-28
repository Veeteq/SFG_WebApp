package com.springframeworkguru.webapp.bootstrap;

import org.springframework.data.repository.CrudRepository;

import com.springframeworkguru.webapp.entity.Person;

public interface PersonRepository extends CrudRepository<Person, String>{

}
