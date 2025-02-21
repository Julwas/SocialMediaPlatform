package hospital.service.impl;

import hospital.dao.IPatientDAO;
import hospital.model.Patient;
import hospital.service.PatientService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class PatientServiceImpl implements PatientService <Patient, Long> {
    private final SqlSessionFactory sqlSessionFactory;

    public PatientServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Long create(Patient patient) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = session.getMapper(IPatientDAO.class);
            patientDAO.create(patient);
            session.commit();
            return patient.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Patient> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = session.getMapper(IPatientDAO.class);
            return patientDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Patient patient) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = session.getMapper(IPatientDAO.class);
            patientDAO.update(patient);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = session.getMapper(IPatientDAO.class);
            patientDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Patient> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPatientDAO patientDAO = session.getMapper(IPatientDAO.class);
            return patientDAO.getAll();
        }
    }
}
