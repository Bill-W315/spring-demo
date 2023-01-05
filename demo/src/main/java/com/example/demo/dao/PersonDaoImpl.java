package com.example.demo.dao;


import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("realDB")
public class PersonDaoImpl implements PersonDao{

    private static List<Person> personList = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person){
        personList.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        personList.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getPerson(){
        return personList;
    }

}
