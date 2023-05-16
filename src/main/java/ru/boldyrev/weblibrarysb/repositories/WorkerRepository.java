package ru.boldyrev.weblibrarysb.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.boldyrev.weblibrarysb.models.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Integer> {

    Optional<Worker> findByUsernameIgnoreCase(String username);
}
