package ru.boldyrev.weblibrarysb.services;

import java.util.List;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boldyrev.weblibrarysb.models.Worker;
import ru.boldyrev.weblibrarysb.repositories.WorkerRepository;
import ru.boldyrev.weblibrarysb.security.Role;

@Service
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class WorkersService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkersService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Transactional(readOnly = true)
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Worker> findAllByRole(Role role) {
        return workerRepository.findAllByRole(role);
    }

    @Transactional
    public void register(Worker worker) {
        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        worker.setPassword(encoder.encode(worker.getPassword()));
        worker.setRole(Role.ROLE_WORKER);
        workerRepository.save(worker);
    }
}
