package hospital.dao.mySQL;

import hospital.dao.AbstractDAO;
import hospital.model.TestResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestResultDAO extends AbstractDAO<TestResult, Long> {

    @Override
    public void create(TestResult testResult) {
        //patient_id_test_result`, `lab_test_id_test_result`, `test_date`, `doctor_id_test_result`, `result
            String sql = "INSERT INTO test_results (patient_id_test_result, lab_test_id_test_result, test_date," +
                    " doctor_id_test_result, result) VALUES (?, ?, ?, ?, ?)";
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
        String sql = "UPDATE test_results SET labTestId = ?, patientId = ?, result = ?, date = ? WHERE test_results_id = ?";
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
