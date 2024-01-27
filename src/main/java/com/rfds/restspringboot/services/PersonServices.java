package com.rfds.restspringboot.services;

import com.rfds.restspringboot.exceptions.ResourceNotFoundException;
import com.rfds.restspringboot.model.Person;
import com.rfds.restspringboot.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public Person findById(Long id){
        logger.info("Finding one person!");
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No records found with this id"));
    }

    public List<Person> findAll(){
        logger.info("Finding all persons!");
        return repository.findAll();
    }

    public Person create(Person person){
        logger.info("Creating one person");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating one person");

        // var?
        var entity = findById(person.getId());

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("Deleting one person");
        var entity = findById(id);
        repository.delete(entity);
    }

}
