package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.dao.PatientDAO;
import hospital.model.Patient;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl extends AbstractDAO<Patient, Long> implements PatientDAO {
    public PatientDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Patient mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Patient(
                rs.getLong("patients_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("gender"),
                rs.getString("address"),
                rs.getLong("contact_number")
        );
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM Patients WHERE patients_id = ?";
    }

    @Override
    protected String getSelectAllQuery() {
        return "SELECT * FROM Patients";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Patients (first_name, last_name, date_of_birth, gender, address, contact_number) VALUES (?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Patients SET first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, address = ?, contact_number = ? WHERE patients_id = ?";
    }

    @Override
    protected String getDeleteByIdQuery() {
        return "DELETE FROM Patients WHERE patients_id = ?";
    }

    @Override
    protected void setIdInStatement(PreparedStatement stmt, Long id) throws SQLException {
        stmt.setLong(1, id);
    }

    @Override
    protected void setInsertStatement(PreparedStatement stmt, Patient entity) throws SQLException {
        stmt.setString(1, entity.getFirstName());
        stmt.setString(2, entity.getLastName());
        stmt.setDate(3, Date.valueOf(entity.getDateOfBirth()));
        stmt.setString(4, entity.getGender());
        stmt.setString(5, entity.getAddress());
        stmt.setLong(6, entity.getContactNumber());
    }

    @Override
    protected void setUpdateStatement(PreparedStatement stmt, Patient entity) throws SQLException {
        stmt.setString(1, entity.getFirstName());
        stmt.setString(2, entity.getLastName());
        stmt.setDate(3, Date.valueOf(entity.getDateOfBirth()));
        stmt.setString(4, entity.getGender());
        stmt.setString(5, entity.getAddress());
        stmt.setLong(6, entity.getContactNumber());
        stmt.setLong(7, entity.getId());
    }

    @Override
    protected List<Patient> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Patient> patients = new ArrayList<>();
        while (rs.next()) {
            patients.add(mapResultSetToEntity(rs));
        }
        return patients;
    }

    @Override
    public Patient findByID(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
