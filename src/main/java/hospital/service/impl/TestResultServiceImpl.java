package hospital.service.impl;

import hospital.dao.ITestResultDAO;
import hospital.model.TestResult;
import hospital.service.TestResultService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TestResultServiceImpl implements TestResultService<TestResult, Long> {
    private final SqlSessionFactory sqlSessionFactory;

    public TestResultServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public Long create(TestResult testResult) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ITestResultDAO testResultDAO = session.getMapper(ITestResultDAO.class);
            testResultDAO.create(testResult);
            session.commit();
            return testResult.getId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<TestResult> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ITestResultDAO testResultDAO = session.getMapper(ITestResultDAO.class);
            return testResultDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(TestResult testResult) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ITestResultDAO testResultDAO = session.getMapper(ITestResultDAO.class);
            testResultDAO.update(testResult);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ITestResultDAO testResultDAO = session.getMapper(ITestResultDAO.class);
            testResultDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<TestResult> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ITestResultDAO testResultDAO = session.getMapper(ITestResultDAO.class);
            return testResultDAO.getAll();
        }
    }

    /*private final TestResultDAOmySQL testResultDAO;

    public TestResultServiceImpl(TestResultDAOmySQL testResultDAO) {
        this.testResultDAO = testResultDAO;
    }

    @Override
    public void create(TestResult testResult) {
        if (testResult != null) {
            try {
                testResultDAO.create(testResult);
            } catch (java.sql.SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("LabTest cannot be null");
        }
    }

    @Override
    public Optional<TestResult> read(Long id) {
        if (id != null) {
            return testResultDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(TestResult testResult) {
        if (testResult != null && testResult.getId() != null) {
            testResultDAO.update(testResult);
        } else {
            throw new IllegalArgumentException("LabTest or ID cannot be null");
        }
    }

    @Override
    public void delete(Long id) {
        if (id != null) {
            testResultDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<TestResult> getAll() {
        return testResultDAO.findAll();
    }*/
}
