package com.levimartines.graphqlexample.services;

import com.levimartines.graphqlexample.models.Author;
import com.levimartines.graphqlexample.models.Book;
import com.levimartines.graphqlexample.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public Optional<Book> findBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    public Book create(Book book, String email) {
        Optional<Author> author = authorService.findAuthorByEmail(email);
        if (author.isPresent()) {
            book.setAuthor(author.get());
            return bookRepository.save(book);
        }
        return null;
    }

    public void delete(String isbn) {
        Optional<Book> book = findBook(isbn);
        book.ifPresent(bookRepository::delete);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
