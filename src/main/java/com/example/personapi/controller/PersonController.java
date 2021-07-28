package com.example.personapi.controller;

import com.example.personapi.dto.response.MessageResponseDTO;
import com.example.personapi.entity.Person;
import com.example.personapi.entity.Phone;
import com.example.personapi.enums.PhoneType;
import com.example.personapi.exception.PersonNotFoundException;
import com.example.personapi.repository.PersonRepository;
import com.example.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){

        return personService.createPerson(person);
    }

    @GetMapping
    public List<Person> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable long id) throws PersonNotFoundException {
        return personService.findById(id);
    }
/*
    @GetMapping("/test")
    public Person testobj(){
        Phone phone = new Phone();
        phone.setType(PhoneType.MOBILE);
        phone.setNumber("(11)999999999");

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(phone);

        Person person = new Person();
        person.setFirstName("Marcos");
        person.setLastName("Andrade");
        person.setCpf("444.444.444-50");
        //person.setBirthDate(LocalDate.parse("03-03-1997"));
        person.setPhones(phoneList);
        return person;
    }
*/
}
