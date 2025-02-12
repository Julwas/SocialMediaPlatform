package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class DepartmentDAOmySQL extends AbstractDAO<Department, Long> {

    @Override
    public Long create(Department department) throws SQLException {
        String sql = "INSERT INTO departments (name, description) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, department.getName());
            ps.setString(2, department.getDescription());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1); // Возвращаем сгенерированный ID
                    }
                }
            }
            throw new SQLException("Creating department failed, no ID obtained.");
        }
    }

    @Override
    public Optional<Department> read(Long id) {
        String sql = "SELECT * FROM departments WHERE department_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Department(
                            resultSet.getLong("department_id"),
                            resultSet.getString("name"),
                            resultSet.getString("description")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reading department with ID " + id, e);
        }
        return Optional.empty();
    }

    @Override
    public void update(Department department) {
        String sql = "UPDATE departments SET name = ?, description = ? WHERE department_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, department.getId());
            ps.setString(2, department.getName());
            ps.setString(3, department.getDescription());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating department", e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM departments WHERE department_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting department with ID " + id, e);
        }
    }

    @Override
    public List<Department> getAll() {
        String sql = "SELECT * FROM departments";
        List<Department> departments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                departments.add(new Department(
                        resultSet.getLong("department_id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all departments", e);
        }
        return departments;
    }
    }

