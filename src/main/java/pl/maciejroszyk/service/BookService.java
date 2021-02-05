package pl.maciejroszyk.service;

import org.springframework.stereotype.Component;
import pl.maciejroszyk.repository.Book;

import java.util.List;

@Component
public interface BookService {
    List<Book>getBooks();
    void addBook(Book book);
    void removeBook(int id);
    Book getBook(long id);
    void editBook(Book book);

}
