package com.example.kafkaproducertemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class BookProducerScheduler {

    private RestTemplate restTemplate=new RestTemplate();
    @Autowired
    private BookProducer bookProducer;

    @Scheduled(fixedRate = 1000)
    public void fetchBooks(){
        List<Book> books=restTemplate.exchange("http://localhost:9090/api/v1/books", HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {
        }).getBody();

        books.forEach(t-> {
            try {
                bookProducer.produce(t);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
