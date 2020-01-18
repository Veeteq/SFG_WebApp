package com.springframeworkguru.webapp.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import com.springframeworkguru.webapp.entity.Publisher;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfiguration {

    @Autowired
    JobBuilderFactory jobBuilderFactory;
    
    @Autowired
    StepBuilderFactory stepBuilderFactory; 
    
    @Bean
    Job job(ItemReader<Publisher> itemReader,
            ItemProcessor<Publisher, Publisher> itemProcessor,
            ItemWriter<Publisher> itemWriter) {

        Step step = stepBuilderFactory.get("ETL-file-load")
                .<Publisher, Publisher> chunk(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("ELT-Job")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }
    
    @Bean
    FlatFileItemReader<Publisher> itemReader(@Value(value = "${input}") Resource resource) {
        FlatFileItemReader<Publisher> fileItemReader = new FlatFileItemReader<>();
        fileItemReader.setResource(resource);
        fileItemReader.setName("CSV-Publisher-Reader");
        fileItemReader.setLinesToSkip(1);
        fileItemReader.setLineMapper(lineMapper());
        
        return fileItemReader;
    }

    @Bean
    public LineMapper<Publisher> lineMapper() {
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(DelimitedLineTokenizer.DELIMITER_TAB);
        tokenizer.setStrict(false);
        tokenizer.setNames(new String[] {"id", "name", "city"});
        
        BeanWrapperFieldSetMapper<Publisher> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Publisher.class);
        
        DefaultLineMapper<Publisher> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        
        return lineMapper;
    }
 }
