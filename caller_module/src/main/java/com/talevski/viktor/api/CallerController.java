package com.talevski.viktor.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.talevski.viktor.model.Person;
import com.talevski.viktor.service.CallerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/caller")
public class CallerController {
    private CallerService callerService;
    private ObjectMapper objectMapper;

    public CallerController(CallerService callerService, ObjectMapper objectMapper) {
        this.callerService = callerService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public String savePerson(@RequestBody Person person) {
        Person savedPerson = callerService.savePerson(person);
        return "The person with ID - '" + savedPerson.getId() + "', first name - '" + savedPerson.getFirstName() + "' and last name - '" + savedPerson.getLastName() + "' was successfully saved.";
    }

    @GetMapping
    public String getPersonById(@RequestParam(name = "personId") Integer personId) {
        Optional<Person> optionalPerson = callerService.getPersonById(personId);
        if (optionalPerson.isPresent()) {
            Person person = objectMapper.convertValue(optionalPerson.get(), Person.class);
            return "The person with ID - '" + personId + "', has a first name - '" + person.getFirstName() + "' and a last name - '" + person.getLastName() + "'.";
        } else return "The person with ID - '" + personId + "', does not exist.";
    }

    @DeleteMapping
    public String deletePersonById(@RequestParam(name = "personId") Integer personId) {
        callerService.deletePersonById(personId);
        return "The person with ID - '" + personId + "' was successfully deleted.";
    }
}
