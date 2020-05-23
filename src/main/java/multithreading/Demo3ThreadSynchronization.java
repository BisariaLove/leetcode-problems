package multithreading;

public class Demo3ThreadSynchronization {

    int counter = 0;

    public synchronized void incrementCounter() {
        counter = counter+1;
    }

    public static void main(String args[]) {
        Demo3ThreadSynchronization obj = new Demo3ThreadSynchronization();
        obj.doWork();

        System.out.println("Counter: " + obj.counter);
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable(){
            public void run() {

                for(int i=0; i<10000; i++) {
                    incrementCounter();
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run() {

                for(int i=0; i<10000; i++) {
                    incrementCounter();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
