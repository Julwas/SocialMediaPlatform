package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientDAOmySQL extends AbstractDAO<Patient, Long> {

  @Override
    public Long create(Patient patient) throws SQLException {

      String sql = "INSERT INTO patients (first_name, last_name, date_of_birth, gender, address, contact_number) " +
              "VALUES (?, ?, ?, ?, ?, ?)";
      try (Connection connection = getConnection();
           PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

          ps.setString(1, patient.getFirstName());
          ps.setString(2, patient.getLastName());
          ps.setDate(3, Date.valueOf(patient.getDateOfBirth()));
          ps.setString(4, patient.getGender());
          ps.setString(5, patient.getAddress());
          ps.setLong(6, patient.getContactNumber());

          int rowsAffected = ps.executeUpdate();

          if (rowsAffected > 0) {
              try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                  if (generatedKeys.next()) {
                      return generatedKeys.getLong(1); // Возвращаем сгенерированный ID
                  } else {
                      throw new SQLException("Creating patient failed, no ID obtained.");
                  }
              }
          } else {
              throw new SQLException("Creating patient failed, no rows affected.");
          }
      }
    }
    @Override
    public Optional<Patient> read(Long id) {
        String sql = "SELECT * FROM patients WHERE patients_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Patient patient = new Patient(
                        rs.getLong("patients_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getLong("contact_number")
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

        String sql = "UPDATE patients SET first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, address = ?," +
                " contact_number = ? WHERE patients_id = ?";
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
        String sql = "DELETE FROM patients WHERE patients_id = ?";
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
                        rs.getLong("patients_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getLong("contact_number")
                );
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }
}