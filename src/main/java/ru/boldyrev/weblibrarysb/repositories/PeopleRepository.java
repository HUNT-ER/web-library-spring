package ru.boldyrev.weblibrarysb.repositories;

import java.util.Optional;
import ru.boldyrev.weblibrarysb.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByNameIgnoreCase(String name);
}
