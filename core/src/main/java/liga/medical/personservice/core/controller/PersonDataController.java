package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/data")
@Api(value = "Api для работы оператора клиники")
public class PersonDataController {

    private PersonDataService personDataService;

    @Autowired
    public PersonDataController(PersonDataService personDataService) {
        this.personDataService = personDataService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    @ApiOperation(value = "Получение списка пациентов")
    public List<PersonData> getPersonData() {
        return personDataService.getPersonData();
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    @ApiOperation(value = "Получение данных пациента по id")
    public PersonData getPersonData(@PathVariable("id") long id) {
        return personDataService.getPersonDataById(id);
    }

    @PostMapping(path = "/post")
    @ApiOperation(value = "Добавление нового пациента в список")
    public void addPersonData(@RequestBody PersonData personData) {
        personDataService.addPersonData(personData);
    }
}