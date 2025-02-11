package hospital.service.impl;

import hospital.dao.mySQL.PrescriptionDAOmySQL;
import hospital.model.Prescription;
import hospital.service.PrescriptionService;

import java.util.List;
import java.util.Optional;

public class PrescriptionServiceImpl implements PrescriptionService<Prescription, Long> {
    private final PrescriptionDAOmySQL prescriptionDAO = new PrescriptionDAOmySQL();

    @Override
    public void create(Prescription prescription) {
        try {
            prescriptionDAO.create(prescription);
        } catch (java.sql.SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Optional<Prescription> read(Long id) {
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
    public void delete(Long id) {

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
