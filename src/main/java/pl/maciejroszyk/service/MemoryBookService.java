package pl.maciejroszyk.service;

import org.springframework.stereotype.Component;
import pl.maciejroszyk.repository.Book;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService implements BookService {
    private long counter=4;
    private final List<Book> books;

    public MemoryBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book book) {
        book.setId(counter);
        books.add(book);
        counter++;
    }

    @Override
    public void removeBook(int id) {
        for (int i = 0; i <books.size(); i++) {
            if (books.get(i).getId()==id)books.remove(i);
        }
    }

    @Override
    public Book getBook(long id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    @Override
    public void editBook(Book book) {
    Long id=book.getId();
        for (Book value : books) {
            if (value.getId().equals(id)) {
                value.setIsbn(book.getIsbn());
                value.setTitle(book.getTitle());
                value.setAuthor(book.getAuthor());
                value.setPublisher(book.getPublisher());
                value.setType(book.getType());
            }
        }



    }
}
