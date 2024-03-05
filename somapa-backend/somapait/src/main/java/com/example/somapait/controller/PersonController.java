package com.example.somapait.controller;

import com.example.somapait.model.Person;
import com.example.somapait.service.PersonService;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> getPersons() throws IOException, CsvValidationException {
        return personService.readCsvFile("C:\\Recuit_Project\\SomapaIT_Test\\somapait\\src\\main\\java\\com\\example\\somapait\\csv\\Template.csv");
    }
}
