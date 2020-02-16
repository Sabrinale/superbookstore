package com.example.superbookstore.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository  extends CrudRepository<Book, Long> {
    Book findById(String id);
}
