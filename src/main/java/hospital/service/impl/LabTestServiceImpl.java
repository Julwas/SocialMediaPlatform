package hospital.service.impl;

import hospital.dao.mySQL.LabTestDAO;
import hospital.model.LabTest;
import hospital.service.LabTestService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LabTestServiceImpl implements LabTestService<LabTest, Long> {
    private final LabTestDAO labTestDAO;

    public LabTestServiceImpl(LabTestDAO labTestDAO) {
        this.labTestDAO = labTestDAO;
    }

    @Override
    public void add(LabTest labTest) {
        if (labTest != null) {
            labTestDAO.create(labTest);
        } else {
            throw new IllegalArgumentException("LabTest cannot be null");
        }
    }

    @Override
    public Optional<LabTest> getById(Long id) throws SQLException {
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
    public void remove(Long id) {
        if (id != null) {
            labTestDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<LabTest> getAll() {
        return labTestDAO.findAll();
    }
}
