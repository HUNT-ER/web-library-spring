package ru.boldyrev.weblibrarysb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "person")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "name")
    @Size(message = "Name size should be less than 100 chars", max = 100)
    @Pattern(message = "Name should be like ''Name Surname''", regexp = "[A-Z][a-z]+\\s[A-Z][a-z]+")
    private String name;

    @NonNull
    @Column(name = "age")
    @Min(message = "Age should be greater than 5", value = 6)
    private int age;

    @OneToMany(mappedBy = "currentOwner")
    private List<Book> books;
}
