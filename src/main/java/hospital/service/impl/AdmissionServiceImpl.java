package hospital.service.impl;

import hospital.dao.mySQL.AdmissionDAOmySQL;
import hospital.model.Admission;
import hospital.service.AdmissionService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AdmissionServiceImpl implements AdmissionService<Admission, Long> {
    private final AdmissionDAOmySQL admissionDAO;
    public AdmissionServiceImpl(AdmissionDAOmySQL admissionDAO) {
        this.admissionDAO = admissionDAO;
    }

    @Override
    public void create(Admission admission) {
        if (admission != null) {
            try {
                admissionDAO.create(admission);
            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("Admission cannot be null");
        }
    }

    @Override
    public Optional<Admission> read(Long id) throws SQLException {
        if (id != null) {
            return admissionDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Admission admission) {
        admissionDAO.update(admission);
    }

    @Override
    public void delete(Long id) {
        admissionDAO.delete(id);
    }

    @Override
    public List<Admission> getAll() {
        return admissionDAO.findAll();
    }
}
