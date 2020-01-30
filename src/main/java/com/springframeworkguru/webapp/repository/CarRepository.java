package com.springframeworkguru.webapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.springframeworkguru.webapp.entity.Car;

public interface CarRepository extends CrudRepository<Car, String>{

}
