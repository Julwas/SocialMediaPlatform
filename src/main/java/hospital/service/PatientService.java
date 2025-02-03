package hospital.service;

import hospital.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    void addPatient(Patient patient);
    Optional<Patient> getPatient(Long id);
    void updatePatient(Patient patient);
    void deletePatient(Long id);
    List<Patient> getAllPatients();
}
