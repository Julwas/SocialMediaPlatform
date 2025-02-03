package hospital.service;

import hospital.model.Medication;

import java.util.List;
import java.util.Optional;

public interface MedicationService {
    void addMedication(Medication medication);
    Optional<Medication> getMedication(Long id);
    void updateMedication(Medication medication);
    void deleteMedication(Long id);
    List<Medication> getAllMedications();
}
