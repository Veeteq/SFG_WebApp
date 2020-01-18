package com.springframeworkguru.webapp.batch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.springframeworkguru.webapp.entity.Publisher;

public class FlatFileItemReaderTest {

    private FlatFileItemReader<Publisher> fileItemReader = new FlatFileItemReader<>();
    private DefaultLineMapper<Publisher> lineMapper;
    private Resource resource;

    @Before
    public void setUp() throws Exception {
        resource = new ClassPathResource("publishers.csv");



        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
        tokenizer.setDelimiter(DelimitedLineTokenizer.DELIMITER_TAB);
        tokenizer.setStrict(false);
        tokenizer.setNames(new String[] {"id", "name", "city"});

        BeanWrapperFieldSetMapper<Publisher> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Publisher.class);

        lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
    }

    @Test
    public void test() throws UnexpectedInputException, ParseException, Exception {
        fileItemReader.setResource(resource);
        fileItemReader.setName("CSV-Publisher-Reader");
        fileItemReader.setLinesToSkip(1);
        fileItemReader.setLineMapper(lineMapper);

        fileItemReader.open(MetaDataInstanceFactory.createStepExecution().getExecutionContext());

        int count = 0;
        try {
            Publisher publisher;
            while ((publisher = fileItemReader.read()) != null) {              
                assertNotNull(publisher);
                System.out.println(publisher);
                count++;
            }
            assertEquals(5, count);
        } catch(Exception e) {
            throw e;
        } finally {
            fileItemReader.close();
        }
    }
}
