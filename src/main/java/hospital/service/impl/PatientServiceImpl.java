package hospital.service.impl;

import hospital.dao.mySQL.PatientDAOmySQL;
import hospital.model.Patient;
import hospital.service.PatientService;

import java.util.List;
import java.util.Optional;


public class PatientServiceImpl implements PatientService <Patient, Long> {
    private final PatientDAOmySQL patientDAO = new PatientDAOmySQL();


    @Override
    public void create(Patient patient) {
        try {
            patientDAO.create(patient);
        } catch (java.sql.SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Optional<Patient> read(Long id) {
        return patientDAO.read(id);
    }

    @Override
    public void update(Patient patient) {
        patientDAO.update(patient);
    }

    @Override
    public void delete(Long id) {
        patientDAO.delete(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientDAO.findAll();
    }
}
