package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.Nurse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NurseDAOmySQL extends AbstractDAO<Nurse, Long> {

    @Override
    public void create(Nurse nurse) {
        String sql = "INSERT INTO nurses (nurses_id, first_name, last_name, assigned_id_department) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, nurse.getDepartmentId());
            ps.setString(2, nurse.getFirstName());
            ps.setString(3, nurse.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Nurse> read(Long id) {
        String sql = "SELECT * FROM nurses WHERE nurses_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Nurse nurse = new Nurse(
                        rs.getLong("nurses_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getLong("assigned_id_department")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Nurse nurse) {
        String sql = "UPDATE nurses SET first_name = ?,last_name = ?, assigned_id_department = ? WHERE nurses_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, nurse.getId());
            ps.setString(2, nurse.getFirstName());
            ps.setString(3, nurse.getLastName());
            ps.setLong(4, nurse.getDepartmentId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM nurses WHERE nurses_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Nurse> findAll() {
        String sql = "SELECT * FROM nurses";
        List<Nurse> nurses = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                if (rs.next()) {
                    Nurse nurse = new Nurse(
                            rs.getLong("nurses_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getLong("assigned_id_department")
                    );
                    nurses.add(nurse);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nurses;
    }
    }

