package com.example.demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AplicationTests {

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer()
            .withUsername("duke")
            .withPassword("password")
            .withDatabaseName("test");

    @Autowired
    private BookRepository bookRepository;

    // requires Spring Boot >= 2.2.6
    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
        registry.add("spring.datasource.password", container::getPassword);
        registry.add("spring.datasource.username", container::getUsername);
    }

    @Test
    @Order(1)
    void saveBook(){
        Book book = new Book();
        book.setTitle("test");
        bookRepository.save(book);
    }


    @Test
    @Order(2)
    void searchByAuthor(){
        List<Book> books = bookRepository.searchByAuthor("some author");
        assertThat(books.size(),equalTo(1));
    }
}
