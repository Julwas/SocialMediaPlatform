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
        String sql = "INSERT INTO prescriptions (patient_id_prescriptions, doctor_id_prescriptions, " +
                "medication_id_prescriptions, dosage, frequency, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
        String sql = "SELECT * FROM patients WHERE prescriptions_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Prescription prescription = new Prescription(
                        rs.getLong("patient_id_prescriptions"),
                rs.getLong( "doctor_id_prescriptions"),
                rs.getLong("medication_id_prescriptions"),
                rs.getString("dosage"),
                rs.getString( "frequency"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate( "end_date").toLocalDate()
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
        String sql = "UPDATE prescription SET patient_id_prescriptions = ?, doctor_id_prescriptions = ?," +
                " medication_id_prescriptions = ?, dosage = ?," +
                " frequency =?, start_date = ?, end_date= ? WHERE prescriptions_id = ?";
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
        String sql = "DELETE FROM prescription WHERE prescriptions_id = ?";
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
        String sql = "SELECT * FROM prescriptions";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prescription prescription = new Prescription(
                        rs.getLong("patient_id_prescriptions"),
                        rs.getLong( "doctor_id_prescriptions"),
                        rs.getLong("medication_id_prescriptions"),
                        rs.getString("dosage"),
                        rs.getString( "frequency"),
                        rs.getDate("start_date").toLocalDate(),
                        rs.getDate( "end_date").toLocalDate()
                );
                prescriptions.add(prescription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prescriptions;
    }
}
