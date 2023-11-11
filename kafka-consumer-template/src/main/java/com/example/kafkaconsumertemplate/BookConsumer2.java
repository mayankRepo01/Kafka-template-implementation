package com.example.kafkaconsumertemplate;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
public class BookConsumer2 {
    Logger logger= LoggerFactory.getLogger(BookConsumer2.class);
    @KafkaListener(topics = "${kafka.topic.json}",groupId = "test2")
    public void consumeMessage(Book book) throws JsonProcessingException, InterruptedException {
        long time=ThreadLocalRandom.current().nextLong(500,2000);
        TimeUnit.MILLISECONDS.sleep(time);
        logger.info("Consume Book Payload by 2:- "+book);

    }
}

