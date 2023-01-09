package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

@RequestMapping("/")
@RestController
public class Controller {

    private final PersonService personService;
    @Autowired
    public Controller(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NonNull @RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPerson(){
        //return new Person(UUID.randomUUID(),"Bill");
        return personService.getPerson();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable UUID id){
        //return personService.getPersonById(id).orElse(new Person());
        return null;
    }
}
