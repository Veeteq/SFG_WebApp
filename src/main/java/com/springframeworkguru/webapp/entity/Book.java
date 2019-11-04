package com.springframeworkguru.webapp.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKS")
@AttributeOverride(name="id", column=@Column(name="BOOK_ID"))
@SequenceGenerator(name="default_seq", sequenceName="BOOK_SEQ", allocationSize=1)
public class Book extends BaseEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name="TITLE")
    private String title;
    
    @Column(name="ISBN")
    private String isbn;
    
    @OneToOne
    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "AUTHOR_BOOK",
            joinColumns = @JoinColumn(
                    name = "BOOK_ID",
                    referencedColumnName = "BOOK_ID"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "AUTHOR_ID",
                    referencedColumnName = "AUTHOR_ID"
            ))
    private Set<Author> authors = new HashSet<>();

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

    @Override
    public String toString() {
        return "Book [title=" + title + ", isbn=" + isbn + ", publisher=" + publisher + "]";
    }
}
