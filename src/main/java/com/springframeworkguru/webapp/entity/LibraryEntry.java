package com.springframeworkguru.webapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "library_entries")
@AttributeOverride(name="id", column=@Column(name="entry_id"))
public class LibraryEntry extends BaseEntity {
    
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "person_id", columnDefinition = "varchar(25)", nullable = true, insertable = true)
    Person person;
 
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = true, insertable = true)
    Book book;
 
    String reservationDate;

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
}
