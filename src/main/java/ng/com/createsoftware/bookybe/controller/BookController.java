package ng.com.createsoftware.bookybe.controller;


import lombok.AllArgsConstructor;
import ng.com.createsoftware.bookybe.model.Book;
import ng.com.createsoftware.bookybe.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
      private final BookService bookService;

      @PostMapping("/add")
      public ResponseEntity<Book> addBook(@RequestBody Book book){
          return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
      }

      @GetMapping("/{id}")
      public ResponseEntity<Book> getBookById(@PathVariable final Long id){
          return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
      }

      @GetMapping
      public ResponseEntity<List<Book>> getBooks(){
          return new ResponseEntity<List<Book>>(bookService.getBooks(), HttpStatus.OK);
      }

      @PutMapping("/{id}")
      public ResponseEntity<Book> editedBook(@PathVariable("id") final Long id, @RequestBody final Book book){
            bookService.editBook(id, book);
          return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
      }
    @DeleteMapping("/{id}")
      public ResponseEntity<Void> deleteBook(@PathVariable final Long id){
          bookService.deleteBook(id);
          return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
      }
}
