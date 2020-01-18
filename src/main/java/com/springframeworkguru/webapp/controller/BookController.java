package com.springframeworkguru.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframeworkguru.webapp.repository.BookRepository;
import com.springframeworkguru.webapp.repository.PublisherRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    
    @Autowired
    public BookController(BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @RequestMapping(path = "/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        
        return "books";
    }
    
    @RequestMapping(path = "/publishers")
    public String getPublishers(Model model) {
        model.addAttribute("publishers", publisherRepository.findAll());
        
        return "publishers";
    }
}
