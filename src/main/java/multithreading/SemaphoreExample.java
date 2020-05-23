package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {

        Connection instance = Connection.getInstance();

        for(int i=0; i<100; i++) {
            instance.connect();
        }
    }

}

class Connection {

    private static Connection instance = new Connection();
    private int connections = 0;
    private Semaphore sem = new Semaphore(5, true);

    private Connection() {}

    public static Connection getInstance() {
        return instance;
    }

    public void connect() throws InterruptedException{

        try{
            sem.acquire();
            doConnect();
        } finally {
            sem.release();
        }
    }

    private void doConnect() throws InterruptedException {
        synchronized (this) {
            connections++;
            System.out.println("Connection Acquired");
        }

        //imitating that thread had to do some work
        Thread.sleep(3000);

        synchronized (this) {
            connections --;
        }
    }
}
