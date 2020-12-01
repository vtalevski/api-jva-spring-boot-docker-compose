package com.talevski.viktor.repository;

import com.talevski.viktor.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalledRepository extends JpaRepository<Person, Integer> {
}
