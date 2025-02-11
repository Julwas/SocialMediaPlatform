package hospital.service.impl;

import hospital.dao.PatientDAO;
import hospital.model.Patient;
import hospital.service.PatientService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Optional;


public class PatientServiceImpl implements PatientService <Patient, Long> {
    private final SqlSessionFactory sqlSessionFactory;

    public PatientServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void create(Patient patient) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PatientDAO patientDAO = session.getMapper(PatientDAO.class);
            patientDAO.insertPatient(patient);
            session.commit();
        }
    }

    @Override
    public Optional<Patient> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PatientDAO patientDAO = session.getMapper(PatientDAO.class);
            return Optional.ofNullable(patientDAO.getPatientById(id));
        }
    }

    @Override
    public void update(Patient patient) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PatientDAO patientDAO = session.getMapper(PatientDAO.class);
            patientDAO.updatePatient(patient);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PatientDAO patientDAO = session.getMapper(PatientDAO.class);
            patientDAO.deletePatient(id);
            session.commit();
        }
    }

    @Override
    public List<Patient> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PatientDAO patientDAO = session.getMapper(PatientDAO.class);
            return patientDAO.getAllPatients();
        }
    }
   /* private final PatientDAOmySQL patientDAO = new PatientDAOmySQL();

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
    }*/
}
