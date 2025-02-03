package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.dao.IAppointmentDAO;
import hospital.model.Admission;
import hospital.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentDAO extends AbstractDAO<Appointment, Long>  {

    @Override
    public void create(Appointment appointment) {
        String sql = "INSERT INTO appointments (patientId, doctorId, appointmentDate, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, appointment.getPatientId());
            ps.setLong(2, appointment.getDoctorId());
            ps.setTimestamp(3, Timestamp.valueOf(appointment.getAppointmentDate()));
            ps.setString(4, appointment.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Appointment> read(Long id) {
        String sql = "SELECT * FROM appointments WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Appointment(
                        rs.getLong("id"),
                        rs.getLong("patientId"),
                        rs.getLong("doctorId"),
                        rs.getTimestamp("appointmentDate").toLocalDateTime(),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Appointment appointment) {
        String sql = "UPDATE appointments SET patientId = ?, doctorId = ?, appointmentDate = ?, status = ? WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, appointment.getPatientId());
            ps.setLong(2, appointment.getDoctorId());
            ps.setTimestamp(3, Timestamp.valueOf(appointment.getAppointmentDate()));
            ps.setString(4, appointment.getStatus());
            ps.setLong(5, appointment.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Appointment> findAll() {
        String sql = "SELECT * FROM appointments";
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getLong("id"),
                        rs.getLong("patientId"),
                        rs.getLong("doctorId"),
                        rs.getTimestamp("appointmentDate").toLocalDateTime(),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
