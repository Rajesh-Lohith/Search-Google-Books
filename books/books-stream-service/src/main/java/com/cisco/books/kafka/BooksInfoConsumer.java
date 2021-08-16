package com.cisco.books.kafka;

import com.cisco.books.entities.Book;
import com.cisco.books.helpers.KafkaHelper;
import com.cisco.books.repository.BooksRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BooksInfoConsumer {
    public final BooksRepository repository;


    @KafkaListener(topics = KafkaHelper.BOOKS_TOPIC, groupId = KafkaHelper.BOOKS_GROUP)
    public void listenGroupFoo(Book book) {
        log.info("Received Message : " + book);
        repository.save(book);
    }
}
