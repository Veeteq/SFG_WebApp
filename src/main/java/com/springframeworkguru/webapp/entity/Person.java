package com.springframeworkguru.webapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {
    
    @Id
    @Column(name = "person_id")
    private String id;

    @Column(name = "person_name")
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<LibraryEntry> libraryEntries = new ArrayList<>();
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<LibraryEntry> getLibraryEntries() {
        return libraryEntries;
    }

    public void setLibraryEntries(List<LibraryEntry> libraryEntries) {
        this.libraryEntries = libraryEntries;
    }

    public void addLibraryRent(LibraryEntry libraryEntry) {
        libraryEntry.setPerson(this);
        this.libraryEntries.add(libraryEntry);
    }
}
