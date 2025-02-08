package hospital.service.impl;

import hospital.dao.mySQL.TestResultDAO;
import hospital.model.TestResult;
import hospital.service.TestResultService;

import java.util.List;
import java.util.Optional;

public class TestResultServiceImpl implements TestResultService<TestResult, Long> {
    private final TestResultDAO testResultDAO;

    public TestResultServiceImpl(TestResultDAO testResultDAO) {
        this.testResultDAO = testResultDAO;
    }

    @Override
    public void create(TestResult testResult) {
        if (testResult != null) {
            testResultDAO.create(testResult);
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
