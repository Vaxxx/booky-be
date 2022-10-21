package ng.com.createsoftware.bookybe.service;

import ng.com.createsoftware.bookybe.model.Book;

import java.util.List;

public interface BookService {
    
    Book addBook(Book book);
    Book getBookById(Long id);
    List<Book> getBooks();
    Book editBook(Long bookId, Book book);
    void deleteBook(Long id);
}
