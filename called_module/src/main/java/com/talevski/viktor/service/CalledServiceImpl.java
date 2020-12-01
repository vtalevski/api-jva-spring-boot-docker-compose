package com.talevski.viktor.service;

import com.talevski.viktor.model.Person;
import com.talevski.viktor.repository.CalledRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalledServiceImpl implements CalledService {
    private CalledRepository calledRepository;

    public CalledServiceImpl(CalledRepository calledRepository) {
        this.calledRepository = calledRepository;
    }

    public Person savePerson(Person person) {
        return calledRepository.save(person);
    }

    public Optional<Person> getPersonById(Integer personId) {
        return calledRepository.findById(personId);
    }

    public void deletePersonById(Integer personId) {
        calledRepository.deleteById(personId);
    }
}
