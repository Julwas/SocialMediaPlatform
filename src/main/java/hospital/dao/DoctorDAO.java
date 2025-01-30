package hospital.dao;

import hospital.model.Doctor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO extends GenericDAO<Doctor, Long>{
    String getSelectByIdQuery();

    String getSelectAllQuery();

    String getInsertQuery();

    String getUpdateQuery();

    String getDeleteByIdQuery();

    void setIdInStatement(PreparedStatement stmt, Long id) throws SQLException;

    void setInsertStatement(PreparedStatement stmt, Doctor entity) throws SQLException;

    void setUpdateStatement(PreparedStatement stmt, Doctor entity) throws SQLException;

    List<Doctor> mapResultSetToList(ResultSet rs) throws SQLException;
}
