package com.example.kafkaproducertemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    BookProducer bookProducer;

    @PostMapping("/publish")
    Book publishEvent(@RequestBody Book book) throws JsonProcessingException {
        bookProducer.produce(book);
        return book;
    }
    @GetMapping("/books")
    List<Book> getBooks(){
        List<Book> books=new ArrayList<>();
        books.add(new Book("1","Test1","23"));
        books.add(new Book("2","Test1","24"));
        books.add(new Book("3","Test1","25"));
        books.add(new Book("4","Test1","26"));

        return books;
    }

}