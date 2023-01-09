package com.example.demo.dao;


import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("realDB")
public class PersonDaoImpl implements PersonDao{

    //private static List<Person> personList = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(JdbcTemplate tmp){
        this.jdbcTemplate = tmp;
    }

    @Override
    public int insertPerson(UUID id, Person person){

        return 1;
    }

    @Override
    public int insertPerson(Person person){
        return 1;
    }

    @Override
    public List<Person> getPerson(){
        String sql = "SELECT id,name FROM person";
        return jdbcTemplate.query(sql,(resultSet , i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            return new Person(id,name);
        });
    }

    @Override
    public Optional<Person> getPersonById(UUID id){
        String sql = "SELECT id,name FROM person WHERE id=? ";
        //queryForObject(sql,param,rowmapper)
        Person person;
        try {
            person = jdbcTemplate.queryForObject(sql, new Object[]{id},
                    (resultSet, i) -> {
                        UUID personId = UUID.fromString(resultSet.getString("id"));
                        String name = resultSet.getString("name");
                        return new Person(id, name);
                    }
            );
        }catch (Exception e){
            return Optional.empty();
        }
        return Optional.ofNullable(person);
    }

}
