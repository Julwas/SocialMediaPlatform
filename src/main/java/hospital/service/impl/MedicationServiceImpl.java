package hospital.service.impl;

import hospital.dao.IMedicationsDAO;

import hospital.model.Medication;
import hospital.service.MedicationService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MedicationServiceImpl implements MedicationService<Medication, Long> {
    private final SqlSessionFactory sqlSessionFactory;

    public MedicationServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Long create(Medication medication) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IMedicationsDAO medicationDAO = session.getMapper(IMedicationsDAO.class);
            medicationDAO.create(medication);
            session.commit();
            return medication.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Medication> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IMedicationsDAO medicationDAO = session.getMapper(IMedicationsDAO.class);
            return medicationDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Medication medication) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IMedicationsDAO medicationDAO = session.getMapper(IMedicationsDAO.class);
            medicationDAO.update(medication);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IMedicationsDAO medicationDAO = session.getMapper(IMedicationsDAO.class);
            medicationDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Medication> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IMedicationsDAO medicationDAO = session.getMapper(IMedicationsDAO.class);
            return medicationDAO.getAll();
        }
    }

    /*private final MedicationsDAOmySQL medicationsDAO;

    public MedicationServiceImpl(MedicationsDAOmySQL medicationsDAO) {
        this.medicationsDAO = medicationsDAO;
    }

    @Override
    public void create(Medication medication) {
        if (medication != null) {
            try {
                medicationsDAO.create(medication);
            } catch (java.sql.SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("Medication cannot be null");
        }
    }

    @Override
    public Optional<Medication> read(Long id) {
        if (id != null) {
            return medicationsDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Medication medication) {
        if (medication != null && medication.getId() != null) {
            medicationsDAO.update(medication);
        } else {
            throw new IllegalArgumentException("Medication or ID cannot be null");
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            medicationsDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Medication> getAll() {
        return medicationsDAO.findAll();
    }*/
}
