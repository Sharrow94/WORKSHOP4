package pl.maciejroszyk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.maciejroszyk.repository.Book;
import pl.maciejroszyk.service.BookService;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }


    @GetMapping("")
    public List<Book> getList() {
        return bookService.getBooks();
    }

    @DeleteMapping(value = "/{id}")
    public void removeBook(@PathVariable("id") int id){
        bookService.removeBook(id);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") int id){
        return bookService.getBook(id);
    }

    @PutMapping("")
    public void editBook(@RequestBody Book book){
        bookService.editBook(book);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

}
