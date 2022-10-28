package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IllnessController {
    private IllnessService illnessService;

    @Autowired
    public IllnessController(IllnessService illnessService) {
        this.illnessService = illnessService;
    }

    @GetMapping(path = "/illness", produces = "application/json")
    public List<Illness> getIllness() {
        return illnessService.getIllness();
    }

    @GetMapping(path = "/illness/{id}", produces = "application/json")
    public Illness getIllness(@PathVariable("id") long id) {
        return illnessService.getIllnessById(id);
    }

    @PostMapping
    public void addIllness(@RequestBody Illness illness) {
        illnessService.addIllness(illness);
    }
}