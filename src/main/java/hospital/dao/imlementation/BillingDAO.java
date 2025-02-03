package hospital.dao.imlementation;

import hospital.dao.AbstractDAO;
import hospital.model.Billing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillingDAO  extends AbstractDAO<Billing, Long>{
    @Override
    public void create(Billing billing) {
        String sql = "INSERT INTO billing (id, patientId, amount, billingDate, paid) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, billing.getId());
            ps.setLong(2, billing.getPatientId());
            ps.setDouble(3, billing.getAmount());
            ps.setString(4, billing.getBillingDate());
            ps.setBoolean(5, billing.getPaid());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Billing> read(Long id) {
        String sql = "SELECT * FROM billing WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Billing(
                        rs.getLong("id"),
                        rs.getLong("patientId"),
                        rs.getDouble("amount"),
                        rs.getString("billingDate"),
                        rs.getBoolean("paid")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(Billing billing) {
        String sql = "UPDATE billing SET patientId = ?, amount = ?, billingDate = ?, paid = ? WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, billing.getPatientId());
            ps.setDouble(2, billing.getAmount());
            ps.setString(3, billing.getBillingDate());
            ps.setBoolean(4, billing.getPaid());
            ps.setLong(5, billing.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM billing WHERE id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Billing> findAll() {
        String sql = "SELECT * FROM billing";
        List<Billing> billings = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                billings.add(new Billing(
                        rs.getLong("id"),
                        rs.getLong("patientId"),
                        rs.getDouble("amount"),
                        rs.getString("billingDate"),
                        rs.getBoolean("paid")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billings;
    }
}
