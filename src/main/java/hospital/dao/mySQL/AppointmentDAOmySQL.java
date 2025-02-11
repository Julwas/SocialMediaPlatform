package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AppointmentDAOmySQL extends AbstractDAO<Appointment, Long>  {

    @Override
    public Long create(Appointment appointment) throws SQLException {
        String sql = "INSERT INTO appointments (patient_id_appointments, doctor_id_appointments, " +
                "appointment_date, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Устанавливаем параметры для PreparedStatement
            ps.setLong(1, appointment.getPatientId());
            ps.setLong(2, appointment.getDoctorId());
            ps.setTimestamp(3, Timestamp.valueOf(appointment.getAppointmentDate()));
            ps.setString(4, appointment.getStatus());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1);
                    } else {
                        throw new SQLException("Creating appointment failed, no ID obtained.");
                    }
                }
            } else {
                throw new SQLException("Creating appointment failed, no rows affected.");
            }
        }
    }

    @Override
    public Optional<Appointment> read(Long id) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE appointment_id = ?";
        ResultSet rs = null;
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Appointment(
                        rs.getLong("appointment_id"),
                        rs.getLong("patient_id_appointments"),
                        rs.getLong("doctor_id_appointments"),
                        rs.getTimestamp("appointment_date").toLocalDateTime(),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            rs.close();
        }
        return Optional.empty();
    }

    @Override
    public void update(Appointment appointment) {
        String sql = "UPDATE appointments SET patient_id_appointments = ?, doctor_id_appointments = ?, appointment_date = ?, status = ?" +
                " WHERE appointment_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, appointment.getId());
            ps.setLong(2, appointment.getPatientId());
            ps.setLong(3, appointment.getDoctorId());
            ps.setTimestamp(4, Timestamp.valueOf(appointment.getAppointmentDate()));
            ps.setString(5, appointment.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM appointments WHERE appointment_id = ?";
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
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                appointments.add(new Appointment(
                        rs.getLong("appointment_id"),
                        rs.getLong("patient_id_appointments"),
                        rs.getLong("doctor_id_appointments"),
                        rs.getTimestamp("appointment_date").toLocalDateTime(),
                        rs.getString("status")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
