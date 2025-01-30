package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.dao.AppointmentDAO;
import hospital.model.Admission;
import hospital.model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOImpl  extends AbstractDAO<Appointment, Long> implements AppointmentDAO {

    public AppointmentDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Appointment mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Appointment(
                rs.getLong("appointment_id"),
                rs.getLong("patient_id"),
                rs.getLong("doctor_id"),
                rs.getTimestamp("appointment_date").toLocalDateTime(),
                rs.getString("status")
        );
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM Appointments WHERE appointment_id = ?";
    }

    @Override
    protected String getSelectAllQuery() {
        return "SELECT * FROM Appointments";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Appointments (patient_id, doctor_id, appointment_date, status) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Appointments SET patient_id = ?, doctor_id = ?, appointment_date = ?, status = ? WHERE appointment_id = ?";
    }

    @Override
    protected String getDeleteByIdQuery() {
        return "DELETE FROM Appointments WHERE appointment_id = ?";
    }

    @Override
    protected void setIdInStatement(PreparedStatement stmt, Long id) throws SQLException {
        stmt.setLong(1, id);
    }

    @Override
    protected void setInsertStatement(PreparedStatement stmt, Appointment entity) throws SQLException {
        stmt.setLong(1, entity.getPatientId());
        stmt.setLong(2, entity.getDoctorId());
        stmt.setTimestamp(3, Timestamp.valueOf(entity.getAppointmentDate()));
        stmt.setString(4, entity.getStatus());
    }

    @Override
    protected void setUpdateStatement(PreparedStatement stmt, Appointment entity) throws SQLException {
        stmt.setLong(1, entity.getPatientId());
        stmt.setLong(2, entity.getDoctorId());
        stmt.setTimestamp(3, Timestamp.valueOf(entity.getAppointmentDate()));
        stmt.setString(4, entity.getStatus());
        stmt.setLong(5, entity.getId());
    }

    @Override
    protected List<Appointment> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        while (rs.next()) {
            appointments.add(mapResultSetToEntity(rs));
        }
        return appointments;
    }

    @Override
    public Appointment findByID(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Admission findById(Long id) throws SQLException {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) throws SQLException {
        return null;
    }
}
