package hospital.service.impl;

import hospital.dao.mySQL.MedicationsDAO;

import hospital.model.Medication;
import hospital.service.MedicationService;

import java.util.List;
import java.util.Optional;

public class MedicationServiceImpl implements MedicationService {
    private final MedicationsDAO medicationsDAO;

    public MedicationServiceImpl(MedicationsDAO medicationsDAO) {
        this.medicationsDAO = medicationsDAO;
    }

    @Override
    public void addMedication(Medication medication) {
        if (medication != null) {
            medicationsDAO.create(medication);
        } else {
            throw new IllegalArgumentException("Medication cannot be null");
        }
    }

    @Override
    public Optional<Medication> getMedication(Long id) {
        if (id != null) {
            return medicationsDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void updateMedication(Medication medication) {
        if (medication != null && medication.getId() != null) {
            medicationsDAO.update(medication);
        } else {
            throw new IllegalArgumentException("Medication or ID cannot be null");
        }
    }

    @Override
    public void deleteMedication(Long id) {
        if (id != null) {
            medicationsDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Medication> getAllMedications() {
        return medicationsDAO.findAll();
    }
}
