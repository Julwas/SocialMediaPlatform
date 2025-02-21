package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.Billing;
import hospital.model.Rooms;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BillingDAOmySQL extends AbstractDAO<Billing, Long>{
    @Override
    public Long create(Billing billing) throws SQLException {
        String sql = "INSERT INTO billing (patient_id_billing, admission_id_billing, total_amount, paid_amount, " +
                "billing_date, payment_status, labtest_id_billing) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, billing.getPatientId());
            ps.setLong(2, billing.getAdmissionId());
            ps.setBoolean(3, billing.getTotalAmount());
            ps.setBoolean(4, billing.getPaidAmount());
            ps.setDate(5, billing.getBillingDate());
            ps.setBoolean(6, billing.getPaymentStatus());
            ps.setLong(7, billing.getLabtestId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1); // Возвращаем сгенерированный ID
                    }
                }
            }
            throw new SQLException("Creating billing failed, no ID obtained.");
        }
    }

    @Override
    public Optional<Billing> read(Long id) throws SQLException {
        String sql = "SELECT * FROM billing WHERE billing_id = ?";
        ResultSet rs = null;
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new Billing(
                        rs.getLong("billing_id"),
                        rs.getLong("patient_id_billing"),
                        rs.getLong("admission_id_billing"),
                        rs.getBoolean("total_amount"),
                        rs.getBoolean("paid_amount"),
                        rs.getDate("billing_date,"),
                        rs.getBoolean("payment_status,"),
                        rs.getLong("labTest_id_billing")
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
    public void update(Billing billing) {
        String sql = "UPDATE billing SET patient_id_billing = ?, admission_id_billing = ?, total_amount = ?," +
                "paid_amount = ?, billing_date = ?, payment_status= ?, labtest_id_billing = ? WHERE billing_id = ? ";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1,billing.getId());
            ps.setLong(2, billing.getPatientId());
            ps.setLong(3, billing.getAdmissionId());
            ps.setBoolean(4, billing.getTotalAmount());
            ps.setBoolean(5, billing.getPaidAmount());
            ps.setDate(6, billing.getBillingDate());
            ps.setBoolean(7, billing.getPaymentStatus());
            ps.setLong(5, billing.getLabtestId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM billing WHERE billing_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Billing> getAll() {
        String sql = "SELECT * FROM billing";
        List<Billing> billings = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                billings.add(new Billing(
                        rs.getLong("billing_id"),
                        rs.getLong("patient_id_billing"),
                        rs.getLong("admission_id_billing"),
                        rs.getBoolean("total_amount"),
                        rs.getBoolean("paid_amount"),
                        rs.getDate("billing_date,"),
                        rs.getBoolean("payment_status,"),
                        rs.getLong("labTest_id_billing")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return billings;
    }
}
