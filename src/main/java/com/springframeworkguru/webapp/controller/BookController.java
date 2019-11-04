package com.springframeworkguru.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springframeworkguru.webapp.repository.BookRepository;

@Controller
public class BookController {

    private BookRepository bookRepository;
    
    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @RequestMapping(path = "/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        
        return "books";
    }
}
