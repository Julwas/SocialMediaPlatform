package hospital.service.impl;

import hospital.dao.imlementation.AppointmentDAO;
import hospital.model.Appointment;
import hospital.service.AppointmentService;

import java.util.List;
import java.util.Optional;

public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentDAO appointmentDAO;
    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {

        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public void addAppointment(Appointment appointment) {
        if (appointment != null) {
            appointmentDAO.create(appointment);
        } else {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
    }

    @Override
    public Optional<Appointment> getAppointment(Long id) {
        if (id != null) {
            return appointmentDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }


    @Override
    public void updateAppointment(Appointment appointment) {
        if (appointment != null && appointment.getId() != null) {
            appointmentDAO.update(appointment);
        } else {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
    }

    @Override
    public void deleteAppointment(Long id) {
        if (id != null) {
            appointmentDAO.delete(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }
    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentDAO.findAll();
    }


}
