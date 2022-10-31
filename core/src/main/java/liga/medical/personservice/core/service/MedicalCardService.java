package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mapper.MedicalCardMapper;
import liga.medical.personservice.core.model.MedicalCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardService {

    private final MedicalCardMapper medicalCardMapper;

    public MedicalCardService(MedicalCardMapper medicalCardMapper) {
        this.medicalCardMapper = medicalCardMapper;
    }

    public List<MedicalCard> getMedicalCard() {
        return medicalCardMapper.listMedicalCard();
    }

    public MedicalCard getMedicalCardById(long id) {
        return medicalCardMapper.getMedicalCardById(id);
    }

    public void addMedicalCard(MedicalCard medicalCard) {
        medicalCardMapper.addMedicalCardInDB(medicalCard);
    }
}
