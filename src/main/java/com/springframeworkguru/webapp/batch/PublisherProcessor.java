package com.springframeworkguru.webapp.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.springframeworkguru.webapp.entity.Publisher;

@Component
public class PublisherProcessor implements ItemProcessor<Publisher, Publisher> {

    @Override
    public Publisher process(Publisher publisher) throws Exception {
        final String name = publisher.getName().toUpperCase();
        final String city = publisher.getCity().toUpperCase();

        final Publisher transformedPublisher = new Publisher();
        transformedPublisher.setId(publisher.getId());
        transformedPublisher.setCity(city);
        transformedPublisher.setName(name);

        System.out.println("Converting (" + publisher + ") into (" + transformedPublisher + ")");

        return transformedPublisher;
    }
}
