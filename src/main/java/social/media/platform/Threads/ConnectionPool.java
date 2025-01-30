package social.media.platform.Threads;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private final BlockingQueue<ConnectionImage> pool;

    public ConnectionPool(int size) {
        pool = new LinkedBlockingQueue<>(size);
        for (int i = 1; i <= size; i++) {
            pool.add(new ConnectionImage("Image_" + i + ".jpg"));
        }
    }
    private static class Holder {
        private static final ConnectionPool INSTANCE = new ConnectionPool(5);
    }
    public static ConnectionPool getInstance() {
        return Holder.INSTANCE;
    }

    public ConnectionImage getConnection() throws InterruptedException {
        return pool.take();
    }

    public void releaseConnection(ConnectionImage connection) {
        pool.offer(connection);
    }
    }


