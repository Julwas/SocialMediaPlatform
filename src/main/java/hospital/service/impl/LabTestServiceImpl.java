package hospital.service.impl;

import hospital.dao.ILabTestDAO;
import hospital.model.LabTest;
import hospital.service.LabTestService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LabTestServiceImpl implements LabTestService<LabTest, Long> {

    private final SqlSessionFactory sqlSessionFactory;

    public LabTestServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Long create(LabTest labTest) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabTestDAO labTestDAO = session.getMapper(ILabTestDAO.class);
            labTestDAO.create(labTest);
            session.commit();
            return  labTest.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<LabTest> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabTestDAO labTestDAO = session.getMapper(ILabTestDAO.class);
            return labTestDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(LabTest labTest) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabTestDAO labTestDAO = session.getMapper(ILabTestDAO.class);
            labTestDAO.update(labTest);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabTestDAO labTestDAO = session.getMapper(ILabTestDAO.class);
            labTestDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<LabTest> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ILabTestDAO labTestDAO = session.getMapper(ILabTestDAO.class);
            return labTestDAO.getAll();
        }
    }
    /*private final LabTestDAOmySQL labTestDAO;

    public LabTestServiceImpl(LabTestDAOmySQL labTestDAO) {
        this.labTestDAO = labTestDAO;
    }

    @Override
    public void create(LabTest labTest) {
        if (labTest != null) {
            try {
                labTestDAO.create(labTest);
            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("LabTest cannot be null");
        }
    }

    @Override
    public Optional<LabTest> read(Long id) throws SQLException {
        if (id != null) {
            return labTestDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(LabTest labTest) {
        if (labTest != null && labTest.getId() != null) {
            labTestDAO.update(labTest);
        } else {
            throw new IllegalArgumentException("LabTest or ID cannot be null");
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            labTestDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<LabTest> getAll() {
        return labTestDAO.findAll();
    }*/
}
