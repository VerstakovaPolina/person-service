package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/card")
@Api(value = "Api для работы оператора клиники")
public class MedicalCardController {
    @Autowired
    private MedicalCardService medicalCardService;

    public MedicalCardController(MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping(path = "/get", produces = "application/json")
    @ApiOperation(value = "Получение списка мед.карт пациентов")
    public List<MedicalCard> getMedicalCard() {
        return medicalCardService.getMedicalCard();
    }

    @GetMapping(path = "/get/{id}", produces = "application/json")
    @ApiOperation(value = "Получение мед.карты пациента по id")
    public MedicalCard getMedicalCard(@PathVariable("id") long id) {
        return medicalCardService.getMedicalCardById(id);
    }

    @PostMapping(path = "/post")
    @ApiOperation(value = "Добавление мед.карт пациентов")
    public void addMedicalCard(@RequestBody MedicalCard medicalCard) {
        medicalCardService.addMedicalCard(medicalCard);
    }
}