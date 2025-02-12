package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.Medication;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicationsDAOmySQL extends AbstractDAO<Medication, Long> {
    @Override
    public Long create(Medication medication) throws SQLException {
        String sql = "INSERT INTO medication (name, description, manufacturer) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, medication.getName());
            ps.setString(2, medication.getDescription());
            ps.setString(3, medication.getManufacturer());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1); // Возвращаем сгенерированный ID
                    }
                }
            }
            throw new SQLException("Creating medication failed, no ID obtained.");
        }
    }

    @Override
    public Optional<Medication> read(Long id) {
        String sql = "SELECT * FROM medication WHERE medications_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Medication medication = new Medication(
                        rs.getLong("medications_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("manufacturer")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Medication medication) {
        String sql = "UPDATE medication SET name = ?,description = ?, manufacturer = ? WHERE medications_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, medication.getId());
            ps.setString(2, medication.getName());
            ps.setString(3, medication.getDescription());
            ps.setString(4, medication.getManufacturer());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM medication WHERE medications_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medication> getAll() {
        String sql = "SELECT * FROM medications";
        List<Medication> medications = new ArrayList<>();

        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                if (rs.next()) {
                    Medication medication= new Medication(
                            rs.getLong("medications_id"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getString("manufacturer")
                    );
                    medications.add(medication);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medications;
    }
}
