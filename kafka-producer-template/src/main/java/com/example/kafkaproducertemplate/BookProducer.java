package com.example.kafkaproducertemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookProducer {
    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    void produce(Book book) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String response=objectMapper.writeValueAsString(book);
        kafkaTemplate.send("mayank1",response);
    }
}
