package com.cisco.books.resource;

import com.cisco.books.entities.Book;
import com.cisco.books.services.BooksService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
@AllArgsConstructor
public class BooksResource {

    private final BooksService service;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(@PathParam("author") String author, @PathParam("title") String title) {
        return ResponseEntity.of(Optional.of(service.getBooksInfo(author, title)));
    }
}
