package ru.boldyrev.weblibrarysb.controllers;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.boldyrev.weblibrarysb.models.Worker;
import ru.boldyrev.weblibrarysb.security.Role;
import ru.boldyrev.weblibrarysb.services.WorkersService;
import ru.boldyrev.weblibrarysb.util.validator.WorkerValidator;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final WorkersService workersService;
    private final WorkerValidator workerValidator;

    @Autowired
    public AdminController(WorkersService workersService, WorkerValidator workerValidator) {
        this.workersService = workersService;
        this.workerValidator = workerValidator;
    }

    @GetMapping
    public String indexPage() {
        return "/admin/index";
    }

    @GetMapping("/workers")
    public String showWorkers(Model model) {
        List<Worker> workers = workersService.findAllByRole(Role.ROLE_WORKER);
        model.addAttribute("workers", workers);
        return "/admin/workers";
    }

    @GetMapping("/workers/new")
    public String doRegistration(@ModelAttribute("worker") Worker worker) {
        return "admin/registration";
    }

    @PostMapping("/workers")
    public String register(@ModelAttribute("worker") @Valid Worker worker, BindingResult errors) {
        workerValidator.validate(worker, errors);

        if (errors.hasErrors()) {
            return "admin/registration";
        }

        workersService.register(worker);

        return "redirect:/admin";
    }
}
