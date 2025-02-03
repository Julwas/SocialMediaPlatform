package hospital.service;

import hospital.model.Nurse;

import java.util.List;
import java.util.Optional;

public interface NurseService {
    void addNurse(Nurse nurse);
    Optional<Nurse> getNurseById(Long id);
    void updateNurse(Nurse nurse);
    void removeNurse(Long id);
    List<Nurse> getAllNurses();
}
