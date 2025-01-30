package hospital.dao;

import hospital.model.Admission;
import hospital.model.Patient;

import java.sql.SQLException;
import java.util.List;

public interface PatientService {
    Admission getPatientById(Long id) throws SQLException;
    List<Patient> getAllPatients() throws SQLException;
    Boolean savePatient(Patient patient) throws SQLException;
    Boolean updatePatient(Patient patient) throws SQLException;
    Boolean deletePatientById(Long id) throws SQLException;

    void addPatient(Patient newPatient);
}
