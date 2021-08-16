package com.cisco.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.cisco")
@EnableJpaRepositories(basePackages = {"com.cisco"})
public class BooksServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksServiceApplication.class, args);
    }

}
