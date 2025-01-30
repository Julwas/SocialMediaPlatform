package hospital.dao.imlementation;

import hospital.dao.GenericDAO;
import hospital.model.Admission;
import hospital.model.LabTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LabTestDAOImpl implements GenericDAO<LabTest, Long> {
    private final Connection connection;

    public LabTestDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Admission findById(Long id) throws SQLException {
        String sql = "SELECT * FROM LabTest WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToLabTest(rs);
            }
        }
        return null;
    }

    @Override
    public List<LabTest> findAll() throws SQLException {
        String sql = "SELECT * FROM LabTest";
        List<LabTest> labTests = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                labTests.add(mapResultSetToLabTest(rs));
            }
        }
        return labTests;
    }

    @Override
    public Boolean deleteById(Object id) {
        return null;
    }

    @Override
    public LabTest findByID(Long id) {
        return null;
    }

    @Override
    public Boolean save(LabTest labTest) throws SQLException {
        String sql = "INSERT INTO LabTest (name, description, cost) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, labTest.getName());
            ps.setString(2, labTest.getDescription());
            ps.setDouble(3, labTest.getCost());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Boolean update(LabTest labTest) throws SQLException {
        String sql = "UPDATE LabTest SET name = ?, description = ?, cost = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, labTest.getName());
            ps.setString(2, labTest.getDescription());
            ps.setDouble(3, labTest.getCost());
            ps.setLong(4, labTest.getId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public LabTest findById(Object id) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM LabTest WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private LabTest mapResultSetToLabTest(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        Double cost = rs.getDouble("cost");
        return new LabTest(id, name, description, cost);
    }
}

