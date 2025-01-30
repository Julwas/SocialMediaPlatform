package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.dao.DepartmentDAO;
import hospital.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl extends AbstractDAO<Department, Long> implements DepartmentDAO {

    public DepartmentDAOImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected Department mapResultSetToEntity(ResultSet rs) throws SQLException {
        return new Department(
                rs.getLong("department_id"),
                rs.getString("name"),
                rs.getString("location")
        );
    }

    @Override
    protected String getSelectByIdQuery() {
        return "SELECT * FROM Departments WHERE department_id = ?";
    }

    @Override
    protected String getSelectAllQuery() {
        return "SELECT * FROM Departments";
    }

    @Override
    protected String getInsertQuery() {
        return "INSERT INTO Departments (name, location) VALUES (?, ?)";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE Departments SET name = ?, location = ? WHERE department_id = ?";
    }

    @Override
    protected String getDeleteByIdQuery() {
        return "DELETE FROM Departments WHERE department_id = ?";
    }

    @Override
    protected void setIdInStatement(PreparedStatement stmt, Long id) throws SQLException {
        stmt.setLong(1, id);
    }

    @Override
    protected void setInsertStatement(PreparedStatement stmt, Department entity) throws SQLException {
        stmt.setString(1, entity.getName());
        stmt.setString(2, entity.getLocation());
    }

    @Override
    protected void setUpdateStatement(PreparedStatement stmt, Department entity) throws SQLException {
        stmt.setString(1, entity.getName());
        stmt.setString(2, entity.getLocation());
        stmt.setLong(3, entity.getId());
    }

    @Override
    protected List<Department> mapResultSetToList(ResultSet rs) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while (rs.next()) {
            departments.add(mapResultSetToEntity(rs));
        }
        return departments;
    }

    @Override
    public Department findByID(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
