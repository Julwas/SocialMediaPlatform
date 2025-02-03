package hospital.service;

import hospital.model.LabTest;

import java.util.List;
import java.util.Optional;

public interface LabTestService {
    void createLabTest(LabTest labTest) ;
    Optional<LabTest> getLabTestById(Long id);
    void updateLabTest(LabTest labTest);
    void removeLabTest(Long id);
    List<LabTest> getAllLabTests();
}

