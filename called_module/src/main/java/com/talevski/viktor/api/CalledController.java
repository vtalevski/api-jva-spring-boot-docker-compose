package com.talevski.viktor.api;

import com.talevski.viktor.model.Person;
import com.talevski.viktor.service.CalledService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/called")
public class CalledController {
    private CalledService calledService;

    public CalledController(CalledService calledService) {
        this.calledService = calledService;
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        return calledService.savePerson(person);
    }

    @GetMapping
    public Optional<Person> getPersonById(@RequestParam(name = "personId") Integer personId) {
        return calledService.getPersonById(personId);
    }

    @DeleteMapping
    public void deletePersonById(@RequestParam(name = "personId") Integer personId) {
        calledService.deletePersonById(personId);
    }
}
