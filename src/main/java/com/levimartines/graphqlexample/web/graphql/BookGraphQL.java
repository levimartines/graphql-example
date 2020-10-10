package com.levimartines.graphqlexample.web.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.levimartines.graphqlexample.models.Book;
import com.levimartines.graphqlexample.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookGraphQL implements GraphQLMutationResolver, GraphQLQueryResolver {

    @Autowired
    private BookService bookService;

    public List<Book> findAllBooks() {
        return bookService.findAll();
    }

    public Optional<Book> findBook(String isbn) {
        return bookService.findBook(isbn);
    }

    public Book createBook(Book book, String email) {
        return bookService.create(book, email);
    }

    public boolean deleteBook(String isbn) {
        bookService.delete(isbn);
        return true;
    }

}
