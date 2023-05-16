package ru.boldyrev.weblibrarysb.repositories;

import java.util.List;
import ru.boldyrev.weblibrarysb.models.Book;
import ru.boldyrev.weblibrarysb.models.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByCurrentOwner(Person person);
    List<Book> findAllByCurrentOwner(Person person, Sort sort);
    List<Book> findBooksByTitleContainingIgnoreCase(String title);
}
