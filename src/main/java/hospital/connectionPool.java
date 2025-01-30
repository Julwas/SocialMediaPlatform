package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class connectionPool {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    private static final int INITIAL_POOL_SIZE = 10;

    private final List<Connection> connectionPool = new ArrayList<>();
    private final List<Connection> usedConnections = new ArrayList<>();

    public connectionPool() throws SQLException {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(createConnection());
        }
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public synchronized Connection getConnection() {
        if (connectionPool.isEmpty()) {
            throw new RuntimeException("No available connections!");
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        connectionPool.add(connection);
        usedConnections.remove(connection);
    }

    public int getPoolSize() {
        return connectionPool.size();
    }
}
