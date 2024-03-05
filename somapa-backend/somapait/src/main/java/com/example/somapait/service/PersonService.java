package com.example.somapait.service;

import com.example.somapait.model.Person;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonService {
    public List<Person> readCsvFile(String filePath) throws IOException, CsvValidationException {
        List<Person> persons = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;

            while ((line = reader.readNext()) != null) {
                Person person = new Person();
                person.setFirstName(line[0]);
                person.setLastName(line[1]);
                person.setGender(line[2]);
                person.setBirthDate(line[3]);
                person.setNationality(line[4]);
                persons.add(person);
            }
        }
        return persons;
    }
}
