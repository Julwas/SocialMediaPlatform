package hospital.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericService <T, ID>{
   ID create(T entity);
     Optional<T> read(ID id) throws SQLException;
     void update(T entity);
     void delete(ID id);
     List<T> getAll();
}
