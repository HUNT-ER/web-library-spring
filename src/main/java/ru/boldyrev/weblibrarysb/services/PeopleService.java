package ru.boldyrev.weblibrarysb.services;

import java.util.List;
import java.util.Optional;
import ru.boldyrev.weblibrarysb.models.Person;
import ru.boldyrev.weblibrarysb.repositories.PeopleRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeopleService {

    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return peopleRepository.findAll(Sort.by("name"));
    }

    @Transactional(readOnly = true)
    public List<Person> findAllSorted(Sort sort) {
        return peopleRepository.findAll(sort);
    }

    @Transactional(readOnly = true)
    public Optional<Person> findById(int id) {
        return peopleRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Person> findByEmail(String name) {
        return peopleRepository.findByNameIgnoreCase(name);
    }

    @Transactional(readOnly = true)
    public Person findWithBooksById(int id) {
        Person person = peopleRepository.findById(id).get();
        Hibernate.initialize(person.getBooks());
        return person;
    }


    @Transactional
    public void save(Person person) {
        peopleRepository.save(person);
    }

    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        peopleRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

}
