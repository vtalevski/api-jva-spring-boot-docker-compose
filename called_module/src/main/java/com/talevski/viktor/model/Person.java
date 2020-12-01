package com.talevski.viktor.model;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(schema = "public", name = "people")
public class Person {

    @Id
    private Integer id;
    private String firstName;
    private String lastName;
}
