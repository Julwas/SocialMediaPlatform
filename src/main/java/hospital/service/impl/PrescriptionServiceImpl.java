package hospital.service.impl;

import hospital.dao.mySQL.PrescriptionDAO;
import hospital.model.Prescription;
import hospital.service.PrescriptionService;

import java.util.List;
import java.util.Optional;

public class PrescriptionServiceImpl implements PrescriptionService<Prescription, Long> {
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @Override
    public void add(Prescription prescription) {
        prescriptionDAO.create(prescription);
    }

    @Override
    public Optional<Prescription> getById(Long id) {
        if (id != null) {
            return prescriptionDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Prescription prescription) {
        if (prescription != null && prescription.getId() != null) {
            prescriptionDAO.update(prescription);
        } else {
            throw new IllegalArgumentException("Prescription ID cannot be null");
        }
    }

    @Override
    public void remove(Long id) {

        if (id != null) {
            prescriptionDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionDAO.findAll();
    }

}
