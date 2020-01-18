package com.springframeworkguru.webapp.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springframeworkguru.webapp.entity.Publisher;
import com.springframeworkguru.webapp.repository.PublisherRepository;

@Component
public class DBWriter implements ItemWriter<Publisher> {

    @Autowired
    PublisherRepository publisherRepository;
    
    @Override
    public void write(List<? extends Publisher> publishers) throws Exception {
        
        System.out.println("Data Saved for Users: " + publishers);
        publisherRepository.saveAll(publishers);
    }
}
