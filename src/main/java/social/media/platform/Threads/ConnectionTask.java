package social.media.platform.Threads;

public class ConnectionTask implements  Runnable{
    private final int threadId;
    public ConnectionTask(int threadId) {
        this.threadId = threadId;
    }
    @Override
    public void run() {
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            System.out.println("Thread-" + threadId + " is waiting for a connection...");
            ConnectionImage connection = pool.getConnection();
            System.out.println("Thread-" + threadId + " acquired connection: " + connection.getUrl());

            connection.open();

            Thread.sleep(2000);

            System.out.println("Thread-" + threadId + " releasing connection: " + connection.getUrl());
            pool.releaseConnection(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread-" + threadId + " was interrupted.");
        }
    }
    }

