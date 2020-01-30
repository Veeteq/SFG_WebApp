package com.springframeworkguru.webapp.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LibraryEntryId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "book_id")
    private Long bookId;
 
    @Column(name = "person_id")
    private String personId;
 
    @SuppressWarnings("unused")
    private LibraryEntryId() {}
 
    public LibraryEntryId(Long bookId, String personId) {
        this.bookId = bookId;
        this.personId = personId;
    }
 
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        LibraryEntryId that = (LibraryEntryId) o;
        return Objects.equals(bookId, that.bookId) &&
               Objects.equals(personId, that.personId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(bookId, personId);
    }
}