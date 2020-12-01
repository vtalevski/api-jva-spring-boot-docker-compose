package com.talevski.viktor.service;

import com.talevski.viktor.model.Person;

import java.util.Optional;

public interface CallerService {
    Person savePerson(Person person);

    Optional<Person> getPersonById(Integer personId);

    void deletePersonById(Integer personId);
}
