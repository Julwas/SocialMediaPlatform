package hospital.dao.imlementation;

import hospital.dao.PatientDAO;
import hospital.dao.PatientService;
import hospital.model.Admission;
import hospital.model.Patient;

import java.sql.SQLException;
import java.util.List;

public class PatientServiceImpl implements PatientService {
    private final PatientDAO patientDAO;

    public PatientServiceImpl(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public Admission getPatientById(Long id) throws SQLException {
        return patientDAO.findById(id);
    }

    @Override
    public List<Patient> getAllPatients() throws SQLException {
        return patientDAO.findAll();
    }

    @Override
    public Boolean savePatient(Patient patient) throws SQLException {
        return patientDAO.save(patient);
    }

    @Override
    public Boolean updatePatient(Patient patient) throws SQLException {
        return patientDAO.update(patient);
    }

    @Override
    public Boolean deletePatientById(Long id) throws SQLException {
        return patientDAO.deleteById(id);
    }
}
