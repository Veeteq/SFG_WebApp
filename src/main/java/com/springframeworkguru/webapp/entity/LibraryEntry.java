package com.springframeworkguru.webapp.entity;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "library_entries")
public class LibraryEntry  {
    
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    LibraryEntryId id;
    
    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id", columnDefinition = "varchar(25)", nullable = true, insertable = true)
    Person person;
 
    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id", nullable = true, insertable = true)
    Book book;
 
    String reservationDate;

    @SuppressWarnings("unused")
    private LibraryEntry() {}

    public LibraryEntry(Book book, Person person) {
        this.book = book;
        this.person = person;
        this.id = new LibraryEntryId(book.getId(), person.getId()); 
    }
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        LibraryEntry that = (LibraryEntry) o;
        return Objects.equals(book, that.book) &&
               Objects.equals(person, that.person);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(book, person);
    }    
}
