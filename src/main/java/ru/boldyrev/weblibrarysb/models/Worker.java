package ru.boldyrev.weblibrarysb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.boldyrev.weblibrarysb.security.Role;

@Entity
@Table(name = "worker")
@Data
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private int workerId;

    @Column(name = "username")
    @Size(min = 2, max = 100, message = "Username should be between 2 and 100 chars")
    @Pattern(regexp = "\\w+", message = "User name should contains only [a-zA-Z0-9_]")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
