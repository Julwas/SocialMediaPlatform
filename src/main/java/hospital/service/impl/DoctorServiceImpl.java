package hospital.service.impl;

import hospital.dao.mySQL.DoctorDAO;
import hospital.model.Doctor;
import hospital.service.DoctorService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DoctorServiceImpl implements DoctorService <Doctor, Long> {
    private final DoctorDAO doctorDAO;
    public DoctorServiceImpl(DoctorDAO doctorDAO) {
        this.doctorDAO = doctorDAO;
    }
    @Override
    public void add(Doctor doctor) {
        if (doctor != null) {
            doctorDAO.create(doctor);
        } else {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
    }



    @Override
    public Optional<Doctor> getById(Long id) throws SQLException {
        if (id != null) {
            return doctorDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Doctor doctor) {
        if (doctor != null && doctor.getId() != null) {
            doctorDAO.update(doctor);
        } else {
            throw new IllegalArgumentException("Doctor or ID cannot be null");
        }
    }



    @Override
    public void remove(Long id) {
        if (id != null) {
            doctorDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public List<Doctor> getAll() {
        return doctorDAO.findAll();
    }
}
