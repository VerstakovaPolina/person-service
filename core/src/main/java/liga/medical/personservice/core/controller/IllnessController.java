package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/illness")
@Api(value = "Api для работы оператора клиники")
public class IllnessController {
    private IllnessService illnessService;

    @Autowired
    public IllnessController(IllnessService illnessService) {
        this.illnessService = illnessService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    @ApiOperation(value = "Получение списка заболеваний пациентов")
    public List<Illness> getIllness() {
        return illnessService.getIllness();
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    @ApiOperation(value = "Получение списка заболеваний пациента по id")
    public Illness getIllness(@PathVariable("id") long id) {
        return illnessService.getIllnessById(id);
    }

    @PostMapping(path = "/post")
    @ApiOperation(value = "Добавление заболеваний пациентов")
    public void addIllness(@RequestBody Illness illness) {
        illnessService.addIllness(illness);
    }
}