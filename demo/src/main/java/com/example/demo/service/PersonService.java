package com.example.demo.service;import com.example.demo.dao.PersonDao;import com.example.demo.model.Person;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.beans.factory.annotation.Qualifier;import org.springframework.stereotype.Service;import java.util.List;import java.util.Optional;import java.util.UUID;@Servicepublic class PersonService {    private final PersonDao personDao;    //Qualifier可以設定PersonDao的impl是誰 (可隨時切換DB實作)    @Autowired    public PersonService(@Qualifier("realDB") PersonDao personDao) {        this.personDao = personDao;    }    public int addPerson(Person person){        return personDao.insertPerson(person);    }    public List<Person> getPerson(){        return personDao.getPerson();    }    public Optional<Person> getPersonById(UUID id){        return personDao.getPersonById(id);    }}