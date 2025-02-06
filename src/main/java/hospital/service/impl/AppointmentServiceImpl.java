package hospital.service.impl;

import hospital.dao.mySQL.AppointmentDAO;
import hospital.model.Appointment;
import hospital.service.AppointmentService;

import java.util.List;
import java.util.Optional;

public class AppointmentServiceImpl implements AppointmentService<Appointment, Long> {
    private final AppointmentDAO appointmentDAO;
    public AppointmentServiceImpl(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public void add(Appointment appointment) {
        if (appointment != null) {
            appointmentDAO.create(appointment);
        } else {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
    }

    @Override
    public Optional<Appointment> getById(Long id) {
        if (id != null) {
            return appointmentDAO.read(id);
        } else {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    @Override
    public void update(Appointment appointment) {
        if (appointment != null && appointment.getId() != null) {
            appointmentDAO.update(appointment);
        } else {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }
    }

    @Override
    public void remove(Long id) {
        appointmentDAO.delete(id);
    }


    @Override
    public List<Appointment> getAll() {
        return appointmentDAO.findAll();
    }


}
