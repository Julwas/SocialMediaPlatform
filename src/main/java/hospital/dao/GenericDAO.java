package hospital.dao;

import hospital.model.Admission;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO <T, L extends Number>{
    T findByID(Long id);

    Boolean save (T entity) throws SQLException;

    Boolean update(T entity) throws SQLException;

    Boolean delete(Long id);

    T findById(Object id);

    Admission findById(Long id) throws SQLException;

    List<T> findAll() throws SQLException;

    Boolean deleteById(Object id);

    Boolean deleteById(Long id) throws SQLException;
}
