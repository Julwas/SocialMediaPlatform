package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.dao.DoctorDAO;
import hospital.model.Doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOImpl extends AbstractDAO<Doctor, Long> implements DoctorDAO {

    public DoctorDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Doctor mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Doctor(
                rs.getLong("doctor_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("specialization"),
                rs.getInt("experience_years"),
                rs.getLong("department_id")
        );
    }

    @Override
    public String getSelectByIdQuery() {
        return "SELECT * FROM Doctors WHERE doctor_id = ?";
    }

    @Override
    public String getSelectAllQuery() {
        return "SELECT * FROM Doctors";
    }

    @Override
    public String getInsertQuery() {
        return "INSERT INTO Doctors (first_name, last_name, specialization, experience_years, department_id) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    public String getUpdateQuery() {
        return "UPDATE Doctors SET first_name = ?, last_name = ?, specialization = ?, experience_years = ?, department_id = ? WHERE doctor_id = ?";
    }

    @Override
    public String getDeleteByIdQuery() {
        return "DELETE FROM Doctors WHERE doctor_id = ?";
    }

    @Override
    public void setIdInStatement(PreparedStatement stmt, Long id) throws SQLException {
        stmt.setLong(1, id);
    }

    @Override
    public void setInsertStatement(PreparedStatement stmt, Doctor entity) throws SQLException {
        stmt.setString(1, entity.getFirstName());
        stmt.setString(2, entity.getLastName());
        stmt.setString(3, entity.getSpecialization());
        stmt.setInt(4, entity.getExperienceYears());
        stmt.setLong(5, entity.getDepartmentId());
    }

    @Override
    public void setUpdateStatement(PreparedStatement stmt, Doctor entity) throws SQLException {
        stmt.setString(1, entity.getFirstName());
        stmt.setString(2, entity.getLastName());
        stmt.setString(3, entity.getSpecialization());
        stmt.setInt(4, entity.getExperienceYears());
        stmt.setLong(5, entity.getDepartmentId());
        stmt.setLong(6, entity.getId());
    }

    @Override
    public List<Doctor> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Doctor> doctors = new ArrayList<>();
        while (rs.next()) {
            doctors.add(mapResultSetToEntity(rs));
        }
        return doctors;
    }

    @Override
    public Doctor findByID(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
