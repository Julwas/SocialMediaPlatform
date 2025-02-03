package hospital.dao;

import java.util.List;
import java.util.Optional;

public interface IGenericDAO<T, ID> {
    void create(T entity);
    Optional<T> read(ID id);
    void update(T entity);
    void delete(ID id);
    List<T> findAll();
}
