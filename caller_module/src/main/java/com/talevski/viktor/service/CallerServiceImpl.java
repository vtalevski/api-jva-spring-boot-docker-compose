package com.talevski.viktor.service;

import com.talevski.viktor.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
public class CallerServiceImpl implements CallerService {

    @Value("${called_api.uri}")
    public String calledUri;

    private RestTemplate restTemplate;

    public CallerServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Person savePerson(Person person) {
        return this.restTemplate.postForObject(calledUri, person, Person.class);
    }

    public Optional<Person> getPersonById(Integer personId) {
        String getUri = generateGetAndDeleteUri(personId);
        return this.restTemplate.getForObject(getUri, Optional.class);
    }

    public void deletePersonById(Integer personId) {
        String deleteUri = generateGetAndDeleteUri(personId);
        this.restTemplate.delete(deleteUri);
    }

    private String generateGetAndDeleteUri(Integer personId) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(calledUri).queryParam("personId", personId);
        return uriComponentsBuilder.toUriString();
    }
}
