package com.springframeworkguru.webapp.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PUBLISHERS")
@AttributeOverride(name="id", column=@Column(name="PUBLISHER_ID"))
@SequenceGenerator(name="default_seq", sequenceName="PUBLISHER_SEQ", allocationSize=1)
public class Publisher extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="NAME")
    private String name;
    
    @Column(name="CITY")
    private String city;

    
    public Publisher() {
    }

    public Publisher(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Publisher [name=" + name + ", city=" + city + "]";
    }
}
