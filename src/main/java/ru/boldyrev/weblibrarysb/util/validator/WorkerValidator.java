package ru.boldyrev.weblibrarysb.util.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.boldyrev.weblibrarysb.models.Worker;
import ru.boldyrev.weblibrarysb.repositories.WorkerRepository;

@Component
public class WorkerValidator implements Validator {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerValidator(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Worker.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Worker worker = (Worker) target;

        if (workerRepository.findByUsernameIgnoreCase(worker.getUsername()).isPresent()) {
            errors.rejectValue("username", "username_exists", "This username already exists");
        }
    }
}
