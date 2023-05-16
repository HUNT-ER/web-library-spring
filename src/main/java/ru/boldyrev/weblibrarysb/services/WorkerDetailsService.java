package ru.boldyrev.weblibrarysb.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.boldyrev.weblibrarysb.models.Worker;
import ru.boldyrev.weblibrarysb.repositories.WorkerRepository;
import ru.boldyrev.weblibrarysb.security.WorkerDetails;

@Service
public class WorkerDetailsService implements UserDetailsService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerDetailsService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Worker> foundPerson = workerRepository.findByUsernameIgnoreCase(username);

        if (foundPerson.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        return new WorkerDetails(foundPerson.get());
    }
}
