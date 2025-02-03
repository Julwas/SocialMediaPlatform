package hospital.service.impl;

import hospital.dao.imlementation.LabTestDAO;
import hospital.dao.imlementation.TestResultDAO;
import hospital.model.TestResult;
import hospital.service.TestResultService;

import java.util.List;
import java.util.Optional;

public class TestResultServiceImpl implements TestResultService {
    private final TestResultDAO testResultDAO;

    public TestResultServiceImpl(TestResultDAO testResultDAO) {
        this.testResultDAO = testResultDAO;
    }
    @Override
    public void createTestResult(TestResult testResult) {
        if (testResult != null) {
            testResultDAO.create(testResult);
        } else {
            throw new IllegalArgumentException("LabTest cannot be null");
        }
    }

    @Override
    public Optional<TestResult> getTestResultById(Long id) {
        if (id != null) {
            return testResultDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void updateTestResut(TestResult testResult) {
        if (testResult != null && testResult.getId() != null) {
            testResultDAO.update(testResult);
        } else {
            throw new IllegalArgumentException("LabTest or ID cannot be null");
        }
    }

    @Override
    public void removeTestResut(Long id) {
        if (id != null) {
            testResultDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<TestResult> getAllTestResults() {
        return testResultDAO.findAll();
    }
}
