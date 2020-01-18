package com.springframeworkguru.webapp.entity;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "publishers")
@AttributeOverride(name="id", column=@Column(name="publisher_id"))
//@SequenceGenerator(name="default_seq", sequenceName="publisher_seq", allocationSize=1)
public class Publisher extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="name")
    private String name;
    
    @Column(name="city")
    private String city;

    @Column(name = "last_update", columnDefinition = "timestamp default current_timestamp", updatable= false, insertable=false)
    private LocalDateTime lastUpdate;
    
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

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Publisher [id=" + super.getId() + ", name=" + name + ", city=" + city + "]";
    }
}
