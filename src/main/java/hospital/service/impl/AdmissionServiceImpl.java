package hospital.service.impl;

import hospital.dao.imlementation.AdmissionDAO;
import hospital.model.Admission;
import hospital.service.AdmissionService;

import java.util.List;
import java.util.Optional;

public class AdmissionServiceImpl implements AdmissionService {
    private final AdmissionDAO admissionDAO;
    public AdmissionServiceImpl(AdmissionDAO admissionDAO) {
        this.admissionDAO = admissionDAO;
    }

    @Override
    public void addAdmission(Admission admission) {
        if (admission != null) {
            admissionDAO.create(admission);
        } else {
            throw new IllegalArgumentException("Admission cannot be null");
        }
    }

    @Override
    public Optional<Optional<Admission>> getAdmissionById(Long id) {
        Optional<Admission> admission = admissionDAO.read(id);
        return Optional.ofNullable(admission);
    }

    @Override
    public void updateAdmission(Admission admission) {
        admissionDAO.update(admission);
    }

    @Override
    public void removeAdmission(Long id) {
        admissionDAO.delete(id);
    }

    @Override
    public List<Admission> getAllAdmissions() {
        return admissionDAO.findAll();
    }
}
