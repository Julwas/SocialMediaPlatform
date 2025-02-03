package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.model.Patient;
import hospital.model.Prescription;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PrescriptionDAO extends AbstractDAO<Prescription, Long> {

    @Override
    public void create(Prescription prescription) {
        String sql = "INSERT INTO patients (patientId, doctorId, medicationId, dosage, frequency, startDate, endDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, prescription.getPatientId());
            ps.setLong(2, prescription.getDoctorId());
            ps.setLong(3, prescription.getMedicationId());
            ps.setString(4, prescription.getDosage());
            ps.setString(5, prescription.getFrequency());
            ps.setDate(6, Date.valueOf(prescription.getStartDate()));
            ps.setDate(7, Date.valueOf(prescription.getEndDate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<Prescription> read(Long id) {
        String sql = "SELECT * FROM patients WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prescription prescription = new Prescription(
                        rs.getLong("patientId"),
                rs.getLong( "doctorId"),
                rs.getLong("medicationId"),
                rs.getString("dosage"),
                rs.getString( "frequency"),
                        rs.getDate("startDate").toLocalDate(),
                        rs.getDate( "endDate").toLocalDate()
                );
                return Optional.of(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Prescription prescription) {
        String sql = "UPDATE prescription SET patientId = ?, doctorId = ?, medicationId = ?, dosage = ?," +
                " frequency =?, startDate = ?, endDate= ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, prescription.getPatientId());
            ps.setLong(2, prescription.getDoctorId());
            ps.setLong(3, prescription.getMedicationId());
            ps.setString(4, prescription.getDosage());
            ps.setString(5, prescription.getFrequency());
            ps.setDate(6, Date.valueOf(prescription.getStartDate()));
            ps.setDate(7, Date.valueOf(prescription.getEndDate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM prescription WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Prescription> findAll() {
        List<Prescription> prescriptions = new ArrayList<>();
        String sql = "SELECT * FROM prescription";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prescription prescription = new Prescription(
                        rs.getLong("patientId"),
                        rs.getLong( "doctorId"),
                        rs.getLong("medicationId"),
                        rs.getString("dosage"),
                        rs.getString( "frequency"),
                        rs.getDate("startDate").toLocalDate(),
                        rs.getDate( "endDate").toLocalDate()
                );
                prescriptions.add(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptions;
    }
}
