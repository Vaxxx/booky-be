package ng.com.createsoftware.bookybe.repository;

import ng.com.createsoftware.bookybe.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
