package com.cisco.books.services;

import com.cisco.books.entities.Book;
import com.cisco.books.helpers.KafkaHelper;
import com.cisco.books.models.GoogleBooksResponse;
import com.cisco.books.repository.BooksRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksService {
    public BooksRepository booksRepository;
    private KafkaTemplate<String, Book> kafkaTemplate;
    private RestTemplate restTemplate;

    public void sendToKafkaStream(Book book) {
        kafkaTemplate.send(KafkaHelper.BOOKS_TOPIC, book);
    }

    public GoogleBooksResponse getBookFromGoogleBooks(String authorName, String bookTitle) {

        String baseUrl
                = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + bookTitle + ",inauthor:" + authorName;
        ResponseEntity<GoogleBooksResponse> response
                = restTemplate.getForEntity(baseUrl, GoogleBooksResponse.class);


        return response.getBody();
    }

    public List<Book> getBooksInfo(String authorName, String bookTitle) {
        List<Book> books = booksRepository.findByVolumeInfoAuthorsContainingAndVolumeInfoTitleContaining(authorName, bookTitle);

        if (books.isEmpty()) {
            GoogleBooksResponse response = getBookFromGoogleBooks(authorName, bookTitle);
            response.getItems().parallelStream().forEach(this::sendToKafkaStream);
            books = response.getItems();
        }
        return books;
    }
}
