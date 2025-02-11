package hospital.service.impl;

import hospital.dao.mySQL.TestResultDAOmySQL;
import hospital.model.TestResult;
import hospital.service.TestResultService;

import java.util.List;
import java.util.Optional;

public class TestResultServiceImpl implements TestResultService<TestResult, Long> {
    private final TestResultDAOmySQL testResultDAO;

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
    }
}
