package ng.com.createsoftware.bookybe.service;

import lombok.AllArgsConstructor;
import ng.com.createsoftware.bookybe.model.Book;
import ng.com.createsoftware.bookybe.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService
{

    private BookRepository repository;

    @Override
    public Book addBook(Book book) {
        Book newBook = new Book();
        newBook.setId(book.getId());
        newBook.setTitle(book.getTitle());
        newBook.setAuthor(book.getAuthor());
        repository.save(newBook);
        return newBook;
    }

    @Override
    public Book getBookById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cannot find book with id: " + id));

    }

    @Override
    public List<Book> getBooks() {
        return repository.findAll().stream().toList();
    }

    @Override
    public Book editBook(Long bookId, Book book) {
      // Book editedBook = repository.findById(bookId).get();
          Book editedBook = getBookById(bookId);
         editedBook.setTitle(book.getTitle());
         editedBook.setAuthor(book.getAuthor());
         repository.save(editedBook);
          return editedBook;
    }


    @Override
    public void deleteBook(Long id) {
           repository.deleteById(id);
    }
}
