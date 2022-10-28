package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalCardController {
    private MedicalCardService medicalCardService;

    @Autowired
    public MedicalCardController(MedicalCardService medicalCardService) {
        this.medicalCardService = medicalCardService;
    }

    @GetMapping(path = "/medicalCard", produces = "application/json")
    public List<MedicalCard> getMedicalCard() {
        return medicalCardService.getMedicalCard();
    }

    @GetMapping(path = "/medicalCard/{id}", produces = "application/json")
    public MedicalCard getMedicalCard(@PathVariable("id") long id) {
        return medicalCardService.getMedicalCardById(id);
    }

    @PostMapping
    public void addMedicalCard(@RequestBody MedicalCard medicalCard) {
        medicalCardService.addMedicalCard(medicalCard);
    }
}