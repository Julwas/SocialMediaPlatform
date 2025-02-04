package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;

import hospital.model.Doctor;
import hospital.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorDAO extends AbstractDAO<Doctor, Long>  {


    @Override
    public void create(Doctor doctor) {
        String sql = "INSERT INTO doctors (doctors_id, first_name, last_name, specialization, department_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, doctor.getId());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getSpecialization());
            ps.setLong(5, doctor.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Doctor> read(Long id) {
        String sql = "SELECT * FROM doctors WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Doctor doctor = new Doctor(
                        rs.getLong("doctors_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("specialization"),
                        rs.getLong("department_id")
                );
                return Optional.of(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Doctor doctor) {
        String sql ="UPDATE doctors SET first_name = ?, last_name = ?, specialization - ?,  department_id - ? ";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, doctor.getId());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getSpecialization());
            ps.setLong(5, doctor.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM doctors WHERE doctors_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctors";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor doctor = new Doctor(
                        rs.getLong("doctors_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("specialization"),
                        rs.getLong("department_id")
                );
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doctors;
    }
}
