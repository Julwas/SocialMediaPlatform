package hospital.dao.imlementation;

import hospital.dao.GenericDAO;
import hospital.model.Admission;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdmissionDAOImpl implements GenericDAO<Admission, Long> {

    private final Connection connection;

    public AdmissionDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Admission findById(Long id) throws SQLException {
        String sql = "SELECT * FROM Admissions WHERE id = 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return mapResultSetToAdmission(rs);
            }
        }
        return null;
    }

    @Override
    public List<Admission> findAll() throws SQLException {
        String sql = "SELECT * FROM Admissions";
        List<Admission> admissions = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                admissions.add(mapResultSetToAdmission(rs));
            }
        }
        return admissions;
    }

    @Override
    public Boolean deleteById(Object id) {
        return null;
    }

    @Override
    public Admission findByID(Long id) {
        return null;
    }

    @Override
    public Boolean save(Admission admission) throws SQLException {
        String sql = "INSERT INTO Admissions (patient_id, room_id, admission_date, discharge_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, admission.getPatientId());
            ps.setLong(2, admission.getRoomId());
            ps.setDate(3, Date.valueOf(admission.getAdmissionDate()));
            ps.setDate(4, admission.getDischargeDate() != null ? Date.valueOf(admission.getDischargeDate()) : null);
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Boolean update(Admission admission) throws SQLException {
        String sql = "UPDATE Admissions SET patient_id = ?, room_id = ?, admission_date = ?, discharge_date = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, admission.getPatientId());
            ps.setLong(2, admission.getRoomId());
            ps.setDate(3, Date.valueOf(admission.getAdmissionDate()));
            ps.setDate(4, admission.getDischargeDate() != null ? Date.valueOf(admission.getDischargeDate()) : null);
            ps.setLong(5, admission.getId());
            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public Admission findById(Object id) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM Admissions WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        }
    }

    private Admission mapResultSetToAdmission(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        Long patientId = rs.getLong("patient_id");
        Long roomId = rs.getLong("room_id");
        LocalDate admissionDate = rs.getDate("admission_date").toLocalDate();
        Date dischargeDate = rs.getDate("discharge_date");
        return new Admission(id, patientId, roomId, admissionDate, dischargeDate != null ? dischargeDate.toLocalDate() : null);
    }
}
