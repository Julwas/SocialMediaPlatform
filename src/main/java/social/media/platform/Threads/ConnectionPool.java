package social.media.platform.Threads;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ConnectionPool {
    private final BlockingQueue<ConnectionImage> pool;

    public ConnectionPool(int size) {
        pool = new LinkedBlockingQueue<>(size);
        for (int i = 1; i <= size; i++) {
            pool.add(new ConnectionImage("Image_" + i + ".jpg"));
        }
    }

    public ConnectionImage getConnection() throws InterruptedException {
        return pool.take();
    }

    public void releaseConnection(ConnectionImage connection) {
        pool.offer(connection);
    }
}

