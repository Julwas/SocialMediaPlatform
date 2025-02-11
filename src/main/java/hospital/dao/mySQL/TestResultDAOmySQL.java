package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.TestResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultDAOmySQL extends AbstractDAO<TestResult, Long> {

    @Override
    public Long create(TestResult testResult) throws SQLException {
        String sql = "INSERT INTO test_results (patient_id_test_result, lab_test_id_test_result, test_date, " +
                "doctor_id_test_result, result) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setLong(1, testResult.getPatientId());
            ps.setLong(2, testResult.getLabTestId());
            ps.setDate(3, testResult.getDate());
            ps.setLong(4, testResult.getDoctorId());
            ps.setString(5, testResult.getResult());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getLong(1); // Возвращаем сгенерированный ID
                    }
                }
            }
            throw new SQLException("Creating test result failed, no ID obtained.");
        }
            }

    @Override
    public Optional<TestResult> read(Long id) {
        String sql = "SELECT * FROM test_results WHERE test_results_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(new TestResult(
                        rs.getLong("test_results_id"),
                        rs.getLong("lab_test_id_test_result"),
                        rs.getLong("patient_id_test_result"),
                        rs.getLong("doctor_id_test_result"),
                        rs.getString("result"),
                        rs.getDate("test_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(TestResult testResult) {
        String sql = "UPDATE test_results SET lab_test_id_test_result = ?, patient_id_test_result = ?," +
                "doctor_id_test_result = ?, test_date = ?, result = ?, WHERE test_results_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, testResult.getId());
            ps.setLong(2, testResult.getLabTestId());
            ps.setLong(3, testResult.getPatientId());
            ps.setLong(4, testResult.getDoctorId());
            ps.setString(5, testResult.getResult());
            ps.setDate(6, testResult.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM test_results WHERE test_results_id = ?";
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TestResult> findAll() {
        String sql = "SELECT * FROM test_results";
        List<TestResult> testResults = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                testResults.add(new TestResult(
                        rs.getLong("test_results_id"),
                        rs.getLong("lab_test_id_test_result"),
                        rs.getLong("patient_id_test_result"),
                        rs.getLong("doctor_id_test_result"),
                        rs.getString("result"),
                        rs.getDate("test_date")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return testResults;
    }
}
