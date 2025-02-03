package hospital.service.impl;

import hospital.dao.imlementation.LabTestDAO;
import hospital.model.LabTest;
import hospital.service.LabTestService;

import java.util.List;
import java.util.Optional;

public class LabTestServiceImpl implements LabTestService {
    private final LabTestDAO labTestDAO;

    public LabTestServiceImpl(LabTestDAO labTestDAO) {
        this.labTestDAO = labTestDAO;
    }

    @Override
    public void createLabTest(LabTest labTest) {
        if (labTest != null) {
            labTestDAO.create(labTest);
        } else {
            throw new IllegalArgumentException("LabTest cannot be null");
        }
    }

    @Override
    public Optional<LabTest> getLabTestById(Long id) {
        if (id != null) {
            return labTestDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void updateLabTest(LabTest labTest) {
        if (labTest != null && labTest.getId() != null) {
            labTestDAO.update(labTest);
        } else {
            throw new IllegalArgumentException("LabTest or ID cannot be null");
        }
    }

    @Override
    public void removeLabTest(Long id) {
        if (id != null) {
            labTestDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<LabTest> getAllLabTests() {
        return labTestDAO.findAll();
    }
}
