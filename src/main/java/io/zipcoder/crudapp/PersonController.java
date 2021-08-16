package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonService service;

    @PostMapping(value = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        return new ResponseEntity<>(service.create(person), HttpStatus.CREATED);
    }

    @GetMapping(value = "/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/people")
    public ResponseEntity<List<Person>> getPeople() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/people/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person) {
        return new ResponseEntity<>(service.update(id, person), HttpStatus.OK);
    }

    @DeleteMapping(value = "/people/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
