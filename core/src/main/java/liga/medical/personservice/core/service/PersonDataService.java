package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mapper.MedicalCardMapper;
import liga.medical.personservice.core.mapper.PersonDataMapper;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.model.PersonData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDataService {

    private final PersonDataMapper personDataMapper;

    public PersonDataService(PersonDataMapper personDataMapper) {
        this.personDataMapper = personDataMapper;
    }

    public List<PersonData> getPersonData() {
        return personDataMapper.listPersonData();
    }

    public PersonData getPersonDataById(long id) {
        return personDataMapper.getPersonDataById(id);
    }

    public void addPersonData(PersonData personData) {
        personDataMapper.addPersonDataInDB(personData);
    }
}
