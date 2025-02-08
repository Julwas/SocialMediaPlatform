package hospital.service.impl;

import hospital.dao.mySQL.MedicationsDAO;

import hospital.model.Medication;
import hospital.service.MedicationService;

import java.util.List;
import java.util.Optional;

public class MedicationServiceImpl implements MedicationService<Medication, Long> {
    private final MedicationsDAO medicationsDAO;

    public MedicationServiceImpl(MedicationsDAO medicationsDAO) {
        this.medicationsDAO = medicationsDAO;
    }

    @Override
    public void create(Medication medication) {
        if (medication != null) {
            medicationsDAO.create(medication);
        } else {
            throw new IllegalArgumentException("Medication cannot be null");
        }
    }

    @Override
    public Optional<Medication> read(Long id) {
        if (id != null) {
            return medicationsDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Medication medication) {
        if (medication != null && medication.getId() != null) {
            medicationsDAO.update(medication);
        } else {
            throw new IllegalArgumentException("Medication or ID cannot be null");
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            medicationsDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Medication> getAll() {
        return medicationsDAO.findAll();
    }
}
