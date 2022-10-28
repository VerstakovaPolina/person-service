package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonDataController {
    private PersonDataService personDataService;

    @Autowired
    public PersonDataController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping(path = "/personData", produces = "application/json")
    public List<PersonData> getPersonData() {
        return personDataService.getPersonData();
    }

    @GetMapping(path = "/personData/{id}", produces = "application/json")
    public PersonData getPersonData(@PathVariable("id") long id) {
        return personDataService.getPersonDataById(id);
    }

    @PostMapping
    public void addPersonData(@RequestBody PersonData personData) {
        personDataService.addPersonData(personData);
    }
}