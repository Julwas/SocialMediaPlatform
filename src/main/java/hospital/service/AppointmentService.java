package hospital.service;

import hospital.model.Appointment;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    void addAppointment(Appointment appointment);
    Optional<Appointment> getAppointment(Long id);
    void updateAppointment(Appointment appointment);
    void deleteAppointment(Long id);
    List<Appointment> getAllAppointments();

}
