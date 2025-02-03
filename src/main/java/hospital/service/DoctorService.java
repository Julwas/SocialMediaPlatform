package hospital.service;

import hospital.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {
    void addDoctor(Doctor doctor);
    Optional<Doctor> getDoctorById(Long id);
    void updateDoctor(Doctor doctor);
    void removeDoctor(Long id);
    List<Doctor> getAllDoctors();
}
