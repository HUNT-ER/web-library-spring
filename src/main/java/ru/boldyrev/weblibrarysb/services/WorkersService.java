package ru.boldyrev.weblibrarysb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.boldyrev.weblibrarysb.models.Worker;
import ru.boldyrev.weblibrarysb.repositories.WorkerRepository;

@Service
public class WorkersService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkersService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Transactional
    public void register(Worker worker) {
        final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        worker.setPassword(encoder.encode(worker.getPassword()));
        workerRepository.save(worker);
    }
}
