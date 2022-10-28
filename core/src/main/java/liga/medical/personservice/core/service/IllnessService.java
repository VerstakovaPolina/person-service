package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mapper.IllnessMapper;
import liga.medical.personservice.core.model.Illness;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessService {

    private final IllnessMapper illnessMapper;

    public IllnessService(IllnessMapper illnessMapper) {
        this.illnessMapper = illnessMapper;
    }

    public List<Illness> getIllness() {
        return illnessMapper.listIllness();
    }

    public Illness getIllnessById(long id) {
        return illnessMapper.getIllnessById(id);
    }

    public void addIllness(Illness illness) {
        illnessMapper.addIllnessInDB(illness);
    }
}
