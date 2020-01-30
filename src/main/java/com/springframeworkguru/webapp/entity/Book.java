package com.springframeworkguru.webapp.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
@AttributeOverride(name="id", column=@Column(name="book_id"))
//@SequenceGenerator(name="default_seq", sequenceName="book_seq", allocationSize=1)
public class Book extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name="title")
    private String title;
    
    @Column(name="isbn")
    private String isbn;
    
    @OneToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "book_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "author_id",
                    referencedColumnName = "author_id"
            ))
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book")
    List<LibraryEntry> persons;
    
    public Book() {
    }

    public Book(String title, String isbn, Publisher publisher) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }

    public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public List<LibraryEntry> getPersons() {
        return persons;
    }

    public void setPersons(List<LibraryEntry> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + "]";
    }
}
