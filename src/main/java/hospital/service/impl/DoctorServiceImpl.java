package hospital.service.impl;

import hospital.dao.imlementation.DoctorDAO;
import hospital.model.Doctor;
import hospital.service.DoctorService;

import java.util.List;
import java.util.Optional;

public class DoctorServiceImpl implements DoctorService {
    private final DoctorDAO doctorDAO;
    public DoctorServiceImpl(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }
    @Override
    public void addDoctor(Doctor doctor) {
        if (doctor != null) {
            doctorDAO.create(doctor);
        } else {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
    }

    @Override
    public Optional<Doctor> getDoctorById(Long id) {
        if (id != null) {
            return doctorDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        if (doctor != null && doctor.getId() != null) {
            doctorDAO.update(doctor);
        } else {
            throw new IllegalArgumentException("Doctor or ID cannot be null");
        }
    }

    @Override
    public void removeDoctor(Long id) {
        if (id != null) {
            doctorDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorDAO.findAll();
    }
}
