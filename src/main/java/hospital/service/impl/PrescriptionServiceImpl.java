package hospital.service.impl;

import hospital.dao.mySQL.PrescriptionDAO;
import hospital.model.Prescription;
import hospital.service.PrescriptionService;

import java.util.List;
import java.util.Optional;

public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    @Override
    public void addPrescription(Prescription prescription) {
        prescriptionDAO.create(prescription);
    }
  @Override
  public Optional<Prescription> getPrescription(Long id) {
      if (id != null) {
          return prescriptionDAO.read(id);
      } else {
          throw new IllegalArgumentException("ID cannot be null");
      }
  }

    @Override
    public void updatePrescription(Prescription prescription) {
        if (prescription != null && prescription.getId() != null) {
            prescriptionDAO.update(prescription);
        } else {
            throw new IllegalArgumentException("Prescription ID cannot be null");
        }
    }

    @Override
    public void deletePrescription(Long id) {

        if (id != null) {
            prescriptionDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.findAll();
    }

}
