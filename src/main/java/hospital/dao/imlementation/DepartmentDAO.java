package hospital.dao.imlementation;

import hospital.ConnectionPool;
import hospital.dao.AbstractDAO;
import hospital.dao.IDepartmentDAO;
import hospital.model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class DepartmentDAO extends AbstractDAO<Department, Long> {

    @Override
    public void create(Department department) {
        String sql = "INSERT INTO department (name, location) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, department.getName());
            ps.setString(2, department.getLocation());
            ps.executeUpdate();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    department.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating department", e);
        }
    }

    @Override
    public Optional<Department> read(Long id) {
        String sql = "SELECT * FROM department WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(new Department(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("location")
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
        String sql = "UPDATE department SET name = ?, location = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, department.getName());
            ps.setString(2, department.getLocation());
            ps.setLong(3, department.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating department", e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM department WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting department with ID " + id, e);
        }
    }

    @Override
    public List<Department> findAll() {
        String sql = "SELECT * FROM department";
        List<Department> departments = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                departments.add(new Department(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("location")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all departments", e);
        }
        return departments;
    }
    }

