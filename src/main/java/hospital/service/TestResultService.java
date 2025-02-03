package hospital.service;

import hospital.model.LabTest;
import hospital.model.TestResult;

import java.util.List;
import java.util.Optional;

public interface TestResultService {
    void createTestResult(TestResult testResult) ;
    Optional<TestResult> getTestResultById(Long id);
    void updateTestResut(TestResult testResult);
    void removeTestResut(Long id);
    List<TestResult> getAllTestResults();
}

