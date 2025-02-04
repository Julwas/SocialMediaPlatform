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
          return patientDAO.read(id);

  }

    @Override
    public void updatePatient(Patient patient) {
            patientDAO.update(patient);
    }

    @Override
    public void deletePatient(Long id) {
            patientDAO.delete(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientDAO.findAll();
    }
}
