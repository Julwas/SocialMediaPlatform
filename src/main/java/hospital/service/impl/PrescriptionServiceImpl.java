package hospital.service.impl;

import hospital.dao.IPrescriptionDAO;
import hospital.dao.mySQL.PrescriptionDAOmySQL;
import hospital.model.Prescription;
import hospital.service.PrescriptionService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PrescriptionServiceImpl implements PrescriptionService<Prescription, Long> {

    private final SqlSessionFactory sqlSessionFactory;

    public PrescriptionServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void create(Prescription prescription) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.create(prescription);
            session.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Prescription> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            return prescriptionDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Prescription prescription) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.update(prescription);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            prescriptionDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Prescription> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPrescriptionDAO prescriptionDAO = session.getMapper(IPrescriptionDAO.class);
            return prescriptionDAO.getAll();
        }
    }
    /*private final PrescriptionDAOmySQL prescriptionDAO = new PrescriptionDAOmySQL();

    @Override
    public void create(Prescription prescription) {
        try {
            prescriptionDAO.create(prescription);
        } catch (java.sql.SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Optional<Prescription> read(Long id) {
        if (id != null) {
            return prescriptionDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Prescription prescription) {
        if (prescription != null && prescription.getId() != null) {
            prescriptionDAO.update(prescription);
        } else {
            throw new IllegalArgumentException("Prescription ID cannot be null");
        }
    }

    @Override
    public void delete(Long id) {

        if (id != null) {
            prescriptionDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionDAO.findAll();
    }*/

}
