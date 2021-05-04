package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public interface BookRepository {
    public List<Book> searchByAuthor(String author);
    public void save(Book b);
}
