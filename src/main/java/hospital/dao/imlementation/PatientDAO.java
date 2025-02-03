package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDAO extends AbstractDAO<Patient, Long> {

  @Override
    public  void create(Patient patient) {
        String sql = "INSERT INTO patients (firstName, lastName, dateOfBirth, gender, address, contactNumber) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setDate(3, Date.valueOf(patient.getDateOfBirth()));
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getAddress());
            ps.setLong(6, patient.getContactNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Optional<Patient> read(Long id) {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient(
                        rs.getLong("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getLong("contactNumber")
                );
                return Optional.of(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
    @Override
    public void update(Patient patient) {
        String sql = "UPDATE patients SET firstName = ?, lastName = ?, dateOfBirth = ?, gender = ?, address = ?," +
                " contactNumber = ? WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, patient.getFirstName());
            ps.setString(2, patient.getLastName());
            ps.setDate(3, Date.valueOf(patient.getDateOfBirth()));
            ps.setString(4, patient.getGender());
            ps.setString(5, patient.getAddress());
            ps.setLong(6, patient.getContactNumber());
            ps.setLong(7, patient.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM patients WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Patient> findAll() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient patient = new Patient(
                        rs.getLong("id"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getLong("contactNumber")
                );
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}