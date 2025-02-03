package hospital.service;

import hospital.model.Admission;

import java.util.List;
import java.util.Optional;

public interface AdmissionService {
    void addAdmission(Admission admission);
    Optional<Optional<Admission>> getAdmissionById(Long id);
    void updateAdmission(Admission admission);
    void removeAdmission(Long id);
    List<Admission> getAllAdmissions();
}
