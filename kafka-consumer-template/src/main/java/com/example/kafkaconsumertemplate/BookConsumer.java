package com.example.kafkaconsumertemplate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookConsumer {
    Logger logger= LoggerFactory.getLogger(BookConsumer.class);
    @KafkaListener(topics = "${kafka.topic.json}",groupId = "test1")
    
    public void consumeMessage(Book book) throws JsonProcessingException {

        logger.info("Consume Book Payload by 1:- "+book);

    }
}
