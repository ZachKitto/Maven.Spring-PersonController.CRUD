package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository repository;

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person findById(Long id) {
        return repository.findOne(id);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person update(Long id, Person newPersonData) {
        Person person = findById(id);
        person.setFirstName(newPersonData.getFirstName());
        person.setLastName(newPersonData.getLastName());
        return repository.save(person);
    }

    public Person delete(Long id) {
        Person person = findById(id);
        repository.delete(id);
        return person;
    }
}
