package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.dao.NurseDAO;
import hospital.model.Nurse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NurseDAOImpl extends AbstractDAO<Nurse, Long> implements NurseDAO {

    public NurseDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Nurse mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Nurse(
                rs.getLong("nurse_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getInt("experience_years"),
                rs.getLong("department_id")
        );
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM Nurses WHERE nurse_id = ?";
    }

    @Override
    protected String getSelectAllQuery() {
        return "SELECT * FROM Nurses";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Nurses (first_name, last_name, experience_years, department_id) VALUES (?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Nurses SET first_name = ?, last_name = ?, experience_years = ?, department_id = ? WHERE nurse_id = ?";
    }

    @Override
    protected String getDeleteByIdQuery() {
        return "DELETE FROM Nurses WHERE nurse_id = ?";
    }

    @Override
    protected void setIdInStatement(PreparedStatement stmt, Long id) throws SQLException {
        stmt.setLong(1, id);
    }

    @Override
    protected void setInsertStatement(PreparedStatement stmt, Nurse entity) throws SQLException {
        stmt.setString(1, entity.getFirstName());
        stmt.setString(2, entity.getLastName());
        stmt.setInt(3, entity.getExperienceYears());
        stmt.setLong(4, entity.getDepartmentId());
    }

    @Override
    protected void setUpdateStatement(PreparedStatement stmt, Nurse entity) throws SQLException {
        stmt.setString(1, entity.getFirstName());
        stmt.setString(2, entity.getLastName());
        stmt.setInt(3, entity.getExperienceYears());
        stmt.setLong(4, entity.getDepartmentId());
        stmt.setLong(5, entity.getId());
    }

    @Override
    protected List<Nurse> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Nurse> nurses = new ArrayList<>();
        while (rs.next()) {
            nurses.add(mapResultSetToEntity(rs));
        }
        return nurses;
    }

    @Override
    public Nurse findByID(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
