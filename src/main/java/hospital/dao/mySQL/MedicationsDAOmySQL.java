package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.Medication;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MedicationsDAOmySQL extends AbstractDAO<Medication, Long> {
    @Override
    public void create(Medication medication) {
        String sql = "INSERT INTO medication (medications_id, name, description, manufacturer) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
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
    public List<Medication> findAll() {
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
