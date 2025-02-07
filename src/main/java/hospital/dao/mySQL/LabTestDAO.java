package hospital.dao.mySQL;

import hospital.dao.IGenericDAO;
import hospital.model.LabTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static hospital.ConnectionPool.getConnection;

public class LabTestDAO implements IGenericDAO<LabTest, Long> {
    @Override
    public void create(LabTest labTest) {
        String sql = "INSERT INTO LabTest (labTest_id, name, description, cost) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, labTest.getId());
            ps.setString(2, labTest.getName());
            ps.setString(3, labTest.getDescription());
            ps.setDouble(4, labTest.getCost());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
    public List<LabTest> findAll() {
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

