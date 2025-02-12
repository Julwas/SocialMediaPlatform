package hospital.service.impl;

import hospital.dao.IAdmissionDAO;
import hospital.dao.mySQL.AdmissionDAOmySQL;
import hospital.model.Admission;
import hospital.service.AdmissionService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AdmissionServiceImpl implements AdmissionService<Admission, Long> {

    private final SqlSessionFactory sqlSessionFactory;

    public AdmissionServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void create(Admission admission) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAdmissionDAO admissionDAO = session.getMapper(IAdmissionDAO.class);
            admissionDAO.create(admission);
            session.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Admission> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAdmissionDAO admissionDAO = session.getMapper(IAdmissionDAO.class);
            return admissionDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Admission admission) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAdmissionDAO admissionDAO = session.getMapper(IAdmissionDAO.class);
            admissionDAO.update(admission);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAdmissionDAO admissionDAO = session.getMapper(IAdmissionDAO.class);
            admissionDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Admission> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAdmissionDAO admissionDAO = session.getMapper(IAdmissionDAO.class);
            return admissionDAO.getAll();
        }
    }
    /* private final AdmissionDAOmySQL admissionDAO;
    public AdmissionServiceImpl(AdmissionDAOmySQL admissionDAO) {
        this.admissionDAO = admissionDAO;
    }


    @Override
    public void create(Admission admission) {
        if (admission != null) {
            try {
                admissionDAO.create(admission);
            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("Admission cannot be null");
        }
    }

    @Override
    public Optional<Admission> read(Long id) throws SQLException {
        if (id != null) {
            return admissionDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Admission admission) {
        admissionDAO.update(admission);
    }

    @Override
    public void delete(Long id) {
        admissionDAO.delete(id);
    }

    @Override
    public List<Admission> getAll() {
        return admissionDAO.findAll();
    }*/
}
