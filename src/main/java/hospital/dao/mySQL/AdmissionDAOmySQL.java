package hospital.dao.mySQL;

import hospital.dao.IGenericDAO;
import hospital.model.Admission;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static hospital.ConnectionPool.getConnection;

public class AdmissionDAOmySQL implements IGenericDAO<Admission, Long> {
    @Override
    public void create(Admission admission) {
        String sql = "INSERT INTO admissions (admissions_id, patient_id_admissions, room_id_admissions, admission_date, " +
                "discharge_date) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, admission.getId());
            ps.setLong(2, admission.getPatientId());
            ps.setLong(3, admission.getRoomId());
            ps.setDate(4, Date.valueOf(admission.getAdmissionDate()));
            ps.setDate(5, Date.valueOf(admission.getDischargeDate()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Admission> read(Long id) throws SQLException {
        String sql = "SELECT * FROM admissions WHERE admissions_id = ?";
        ResultSet rs = null;
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Admission(
                        rs.getLong("admissions_id"),
                        rs.getLong("patient_id_admissions"),
                        rs.getLong("room_id_admissions"),
                        rs.getDate("admission_date").toLocalDate(),
                        rs.getDate("discharge_date").toLocalDate()
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
    public void update(Admission admission) {
        String sql = "UPDATE admissions SET patient_id_admissions = ?, room_id_admissions = ?, admission_date = ?, " +
                "discharge_date = ? WHERE admissions_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, admission.getPatientId());
            ps.setLong(2, admission.getRoomId());
            ps.setDate(3, Date.valueOf(admission.getAdmissionDate()));
            ps.setDate(4, Date.valueOf(admission.getDischargeDate()));
            ps.setLong(5, admission.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM admissions WHERE admissions_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Admission> findAll() {
        String sql = "SELECT * FROM admissions";
        List<Admission> admissions = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                admissions.add(new Admission(
                        rs.getLong("admissions_id"),
                        rs.getLong("patient_id_admissions"),
                        rs.getLong("room_id_admissions"),
                        rs.getDate("admission_date").toLocalDate(),
                        rs.getDate("discharge_date").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admissions;
    }

}
