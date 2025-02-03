package hospital.service.impl;

import hospital.dao.imlementation.NurseDAO;
import hospital.model.Nurse;
import hospital.service.NurseService;

import java.util.List;
import java.util.Optional;

public class NurseServiceImpl implements NurseService {
    private final NurseDAO nurseDAO;

    public NurseServiceImpl(NurseDAO nurseDAO) {
        this.nurseDAO = nurseDAO;
    }

    @Override
    public void addNurse(Nurse nurse) {
        if (nurse != null) {
            nurseDAO.create(nurse);
        } else {
            throw new IllegalArgumentException("Nurse cannot be null");
        }
    }

    @Override
    public Optional<Nurse> getNurseById(Long id) {
        if (id != null) {
            return nurseDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void updateNurse(Nurse nurse) {
        if (nurse != null && nurse.getId() != null) {
            nurseDAO.update(nurse);
        } else {
            throw new IllegalArgumentException("Nurse or ID cannot be null");
        }
    }

    @Override
    public void removeNurse(Long id) {
        if (id != null) {
            nurseDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Nurse> getAllNurses() {
        return nurseDAO.findAll();
    }
}
