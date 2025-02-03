package hospital;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static final int INITIAL_POOL_SIZE = 5;

    private static final Queue<Connection> connectionPool = new LinkedList<>();

    static {
        try {
            for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
                connectionPool.add(DriverManager.getConnection(URL, USER, PASSWORD));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing connection pool", e);
        }
    }

    public static synchronized Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connectionPool.poll();
    }

    public static synchronized void releaseConnection(Connection connection) {
        if (connection != null) {
            connectionPool.offer(connection);
        }
    }
}
