package hospital.dao;

import hospital.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

 public abstract class AbstractDAO <T, ID >  implements IGenericDAO<T, ID> {
     protected Connection getConnection() throws SQLException {
         return ConnectionPool.getConnection();
     }

     protected void releaseConnection(Connection connection) {
         ConnectionPool.releaseConnection(connection);
     }
 }