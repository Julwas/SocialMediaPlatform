package hospital.service.impl;

import hospital.dao.IAppointmentDAO;
import hospital.dao.mySQL.AppointmentDAOmySQL;
import hospital.model.Appointment;
import hospital.service.AppointmentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AppointmentServiceImpl implements AppointmentService<Appointment, Long> {
    private final SqlSessionFactory sqlSessionFactory;

    public AppointmentServiceImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void create(Appointment appointment) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            appointmentDAO.create(appointment);
            session.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Appointment> read(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            return appointmentDAO.read(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Appointment appointment) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            appointmentDAO.update(appointment);
            session.commit();
        }
    }

    @Override
    public void delete(Long id) {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            appointmentDAO.delete(id);
            session.commit();
        }
    }

    @Override
    public List<Appointment> getAll() {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDAO = session.getMapper(IAppointmentDAO.class);
            return appointmentDAO.getAll();
        }
    }

   /* private final AppointmentDAOmySQL appointmentDAO;
    public AppointmentServiceImpl(AppointmentDAOmySQL appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    @Override
    public void create(Appointment appointment) {
        if (appointment != null) {
            try {
                appointmentDAO.create(appointment);
            } catch (SQLException throwables) {
                throw new RuntimeException(throwables);
            }
        } else {
            throw new IllegalArgumentException("Appointment cannot be null");
        }
    }

    @Override
    public Optional<Appointment> read(Long id) throws SQLException {
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
    public void delete(Long id) {
        appointmentDAO.delete(id);
    }


    @Override
    public List<Appointment> getAll() {
        return appointmentDAO.findAll();
    }*/
}
