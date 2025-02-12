package hospital.dao.mySQL;

import hospital.dao.IGenericDAO;
import hospital.model.LabTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static hospital.ConnectionPool.getConnection;

public class LabTestDAOmySQL implements IGenericDAO<LabTest, Long> {
    @Override
    public Long create(LabTest labTest) throws SQLException {
        String sql = "INSERT INTO lab_test (name, description, cost) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, labTest.getName());
            ps.setString(2, labTest.getDescription());
            ps.setDouble(3, labTest.getCost());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1); // Возвращаем сгенерированный ID
                    }
                }
            }
            throw new SQLException("Creating lab test failed, no ID obtained.");
        }
    }

    @Override
    public Optional<LabTest> read(Long id) throws SQLException {
        String sql = "SELECT * FROM LabTest WHERE labTest_id = ?";
        ResultSet rs = null;
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new LabTest(
                        rs.getLong("labTest_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("cost")
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
    public void update(LabTest labTest) {
        String sql = "UPDATE LabTest SET name = ?, description = ?, cost = ? WHERE labTest_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, labTest.getName());
            ps.setString(2, labTest.getDescription());
            ps.setDouble(3, labTest.getCost());
            ps.setLong(4, labTest.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM LabTest WHERE labTest_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<LabTest> getAll() {
        String sql = "SELECT * FROM LabTest";
        List<LabTest> labTests = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                labTests.add(new LabTest(
                        rs.getLong("labTest_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("cost")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return labTests;
    }
}

