package hospital.service.impl;

import hospital.dao.imlementation.PatientDAO;
import hospital.model.Patient;
import hospital.service.PatientService;

import java.util.List;
import java.util.Optional;

public class PatientServiceImpl implements PatientService {
    private final PatientDAO patientDAO = new PatientDAO();
    @Override
    public void addPatient(Patient patient) {
        patientDAO.create(patient);
    }
  @Override
  public Optional<Patient> getPatient(Long id) {
      if (id != null) {
          return patientDAO.read(id);
      } else {
          throw new IllegalArgumentException("ID cannot be null");
      }
  }

    @Override
    public void updatePatient(Patient patient) {
        if (patient != null && patient.getId() != null) {
            patientDAO.update(patient);
        } else {
            throw new IllegalArgumentException("Patientor ID cannot be null");
        }
    }

    @Override
    public void deletePatient(Long id) {

        if (id != null) {
            patientDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.findAll();
    }
}
