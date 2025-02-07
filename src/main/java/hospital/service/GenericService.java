package hospital.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericService <T, ID>{
    void add(T entity);
    Optional<T> getById(ID id) throws SQLException;
    void update(T entity);
    void remove(ID id);
    List<T> getAll();
}
