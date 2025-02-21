package hospital.dao;


import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IGenericDAO<T, ID> {
    ID create(T entity) throws SQLException;
    Optional<T> read(Long id) throws SQLException;
    void update(T entity);
    void delete(Long id);
    List<T> getAll();
}
