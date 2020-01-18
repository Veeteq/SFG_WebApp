package com.springframeworkguru.webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springframeworkguru.webapp.entity.Author;
import com.springframeworkguru.webapp.entity.Book;
import com.springframeworkguru.webapp.entity.Publisher;
import com.springframeworkguru.webapp.repository.AuthorRepository;
import com.springframeworkguru.webapp.repository.BookRepository;
import com.springframeworkguru.webapp.repository.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    
    private final boolean canLoad = true; 

    @Autowired
    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
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
    }
}
