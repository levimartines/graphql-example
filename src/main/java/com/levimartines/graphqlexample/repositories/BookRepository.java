package com.levimartines.graphqlexample.repositories;

import com.levimartines.graphqlexample.models.Author;
import com.levimartines.graphqlexample.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
}
