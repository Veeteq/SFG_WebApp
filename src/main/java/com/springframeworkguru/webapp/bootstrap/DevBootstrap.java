package com.springframeworkguru.webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springframeworkguru.webapp.entity.Author;
import com.springframeworkguru.webapp.entity.Book;
import com.springframeworkguru.webapp.entity.Car;
import com.springframeworkguru.webapp.entity.LibraryEntry;
import com.springframeworkguru.webapp.entity.Person;
import com.springframeworkguru.webapp.entity.Publisher;
import com.springframeworkguru.webapp.repository.AuthorRepository;
import com.springframeworkguru.webapp.repository.BookRepository;
import com.springframeworkguru.webapp.repository.CarRepository;
import com.springframeworkguru.webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private CarRepository carRepository;
    private PersonRepository personRepository;
    private final boolean canLoad = true; 

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, CarRepository carRepository, PersonRepository personRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.carRepository = carRepository;
        this.personRepository = personRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(canLoad) {
            loadData();
        }
    }
    
    private void loadData() {
        Author eric = new Author("Eric", "Evans");
        Publisher harper = new Publisher("Harper Collins", "Washington");
        Book ddd = new Book("Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);        
        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);
                
        Author rod = new Author("Rod", "Johnson");
        Publisher oreily = new Publisher("O'Reilly", "Newton");
        Book j2ee = new Book("J2EE Development without EJB", "2222", oreily);
        j2ee.getAuthors().add(rod);        
        authorRepository.save(rod);
        publisherRepository.save(oreily);
        bookRepository.save(j2ee);
        
        Author martin = new Author("Robert", "Martin");
        Publisher pearson = new Publisher("Pearson Education", "London");
        Book cc = new Book("Clean Code", "3232", pearson);
        cc.getAuthors().add(martin);        
        authorRepository.save(martin);
        publisherRepository.save(pearson);
        bookRepository.save(cc);        
        
        Car car1 = new Car();
        car1.setId("car1");
        car1.setName("Ford");
        carRepository.save(car1);
          
        Person person1 = new Person();
        person1.setId("person1");
        person1.setName("John");
        
        Person person2 = new Person();
        person2.setId("person2");
        person2.setName("Mary");
        personRepository.save(person2);
        
        Car car2 = new Car();
        car2.setId("car2");
        car2.setName("Honda");
        car2.setOwner(person1);
        carRepository.save(car2);
        
        Car car3 = new Car();
        car3.setId("car3");
        car3.setName("GMC");
        car3.setOwner(person1);
        car3.setDriver(person1);
        carRepository.save(car3);

        Person person3 = new Person();
        person3.setId("person3");
        person3.setName("Bill");
        
        LibraryEntry entry = new LibraryEntry();
        entry.setBook(ddd);
        entry.setPerson(person3);
        entry.setReservationDate("today");
        
        person3.addLibraryRent(entry);
        personRepository.save(person3);
    }
}
