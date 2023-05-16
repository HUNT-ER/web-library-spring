package ru.boldyrev.weblibrarysb.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "book")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @Column(name = "title")
    @NotEmpty(message = "Title should not be empty")
    @Size(message = "Title should be less than 100 chars", max = 100)
    private String title;

    @NonNull
    @Column(name = "author")
    @NotEmpty(message = "Author should not be empty")
    @Size(message = "Author name should be less than 100 chars", max = 100)
    private String author;

    @NonNull
    @Column(name = "year")
    @Min(message = "Year should be greater then 1900", value = 1900)
    private int year;

    @Column(name = "assignation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date assignationDate;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person currentOwner;

    @Transient
    public boolean isExpired;
}
