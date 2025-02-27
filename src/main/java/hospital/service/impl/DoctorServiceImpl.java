package hospital.service.impl;

import hospital.dao.IDoctorDAO;
import hospital.model.Doctor;
import hospital.service.DoctorService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DoctorServiceImpl implements DoctorService <Doctor, Long> {
    private final SqlSessionFactory sqlSessionFactory;

    public DoctorServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Long create(Doctor doctor) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDAO = session.getMapper(IDoctorDAO.class);
            doctorDAO.create(doctor);
            session.commit();
            return doctor.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Doctor> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDAO = session.getMapper(IDoctorDAO.class);
            return doctorDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Doctor doctor) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDAO = session.getMapper(IDoctorDAO.class);
            doctorDAO.update(doctor);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDAO = session.getMapper(IDoctorDAO.class);
            doctorDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Doctor> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDAO = session.getMapper(IDoctorDAO.class);
            return doctorDAO.getAll();
        }
    }
    /* private final DoctorDAOmySQL doctorDAO;
    public DoctorServiceImpl(DoctorDAOmySQL doctorDAO) {
        this.doctorDAO = doctorDAO;
    }
    @Override
    public void create(Doctor doctor) {
        if (doctor != null) {
            try {
                doctorDAO.create(doctor);
            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
    }



    @Override
    public Optional<Doctor> read(Long id) throws SQLException {
        if (id != null) {
            return doctorDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Doctor doctor) {
        if (doctor != null && doctor.getId() != null) {
            doctorDAO.update(doctor);
        } else {
            throw new IllegalArgumentException("Doctor or ID cannot be null");
        }
    }



    @Override
    public void delete(Long id) {
        if (id != null) {
            doctorDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Doctor> getAll() {
        return doctorDAO.findAll();
    }*/
}
