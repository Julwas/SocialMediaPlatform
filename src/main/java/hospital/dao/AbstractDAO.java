package hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO <T, ID>  implements GenericDAO<T, ID> {
    protected final Connection connection;

    public AbstractDAO(Connection connection) {
        this.connection = connection;
    }

    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;

    @Override
    public T findById(Object id) {
        String query = getSelectByIdQuery();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setIdInStatement(stmt, (ID) id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        String query = getSelectAllQuery();
        try (PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            return mapResultSetToList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean save(T entity) {
        String query = getInsertQuery();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setInsertStatement(stmt, entity);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(T entity) {
        String query = getUpdateQuery();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setUpdateStatement(stmt, entity);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteById(Object id) {
        String query = getDeleteByIdQuery();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            setIdInStatement(stmt, (ID) id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected abstract String getSelectByIdQuery();

    protected abstract String getSelectAllQuery();

    protected abstract String getInsertQuery();

    protected abstract String getUpdateQuery();

    protected abstract String getDeleteByIdQuery();

    protected abstract void setIdInStatement(PreparedStatement stmt, ID id) throws SQLException;

    protected abstract void setInsertStatement(PreparedStatement stmt, T entity) throws SQLException;

    protected abstract void setUpdateStatement(PreparedStatement stmt, T entity) throws SQLException;

    protected abstract List<T> mapResultSetToList(ResultSet rs) throws SQLException;
}
