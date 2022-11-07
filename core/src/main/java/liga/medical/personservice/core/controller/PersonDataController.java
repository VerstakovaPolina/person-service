package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.PersonDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
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
        log.info("\nПолучение списка пациентов");
        return personDataService.getPersonData();
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    @ApiOperation(value = "Получение данных пациента по id")
    public PersonData getPersonData(@PathVariable("id") long id) {
        log.info("\nПолучение данных пациента по id");
        return personDataService.getPersonDataById(id);
    }

    @PostMapping(path = "/post")
    @ApiOperation(value = "Добавление нового пациента в список")
    public void addPersonData(@RequestBody PersonData personData) {
        log.info("\nДобавление нового пациента в список");
        personDataService.addPersonData(personData);
    }
}