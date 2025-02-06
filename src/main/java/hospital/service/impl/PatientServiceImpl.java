package hospital.service.impl;

import hospital.dao.mySQL.PatientDAO;
import hospital.model.Patient;
import hospital.service.PatientService;

import java.util.List;
import java.util.Optional;


public class PatientServiceImpl implements PatientService <Patient, Long> {
    private final PatientDAO patientDAO = new PatientDAO();


    @Override
    public void add(Patient patient) {
        patientDAO.create(patient);
    }

    @Override
    public Optional<Patient> getById(Long id) {
        return patientDAO.read(id);
    }

    @Override
    public void update(Patient patient) {
        patientDAO.update(patient);
    }

    @Override
    public void remove(Long id) {
        patientDAO.delete(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientDAO.findAll();
    }
}
