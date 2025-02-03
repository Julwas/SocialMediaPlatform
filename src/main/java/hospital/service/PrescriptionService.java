package hospital.service;

import hospital.model.Prescription;

import java.util.List;
import java.util.Optional;

public interface PrescriptionService {
    void addPrescription(Prescription prescription);
    Optional<Prescription> getPrescription(Long id);
    void updatePrescription(Prescription prescription);
    void deletePrescription(Long id);
    List<Prescription> getAllPrescriptions();
}
