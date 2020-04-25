package multithreading;


//creating Threads extending Thread class
class Runner extends Thread {
    @Override
    public void run() {

        for(int i=0;i<10;i++) {
            System.out.println(this.getName() + " index: " + i);

            try{
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("Error: " + ie.getMessage());
            }
        }

    }
}

//creating Threads implemnting Runner interface
class RunnerUsingInterface implements Runnable {

    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println(this.getClass()+ " index: " + i);

            try{
                Thread.sleep(1000);
            } catch (InterruptedException ie) {
                System.out.println("Error: " + ie.getMessage());
            }
        }
    }
}

public class ThreadCreationMethods {
    public static void main(String[] args) throws Exception{
        //Difference between starting a thread using start() vs run()
        // If you use run() , it runs your code but it  runs using the main thread of the application
        // if I run a thread using the start(), it tells the method to create its own thread and then run the code within that tread
        Runner r1 = new Runner();
        r1.start();

        Thread t2 = new Thread(new RunnerUsingInterface());
        t2.start();

        //Anonymous Class
        Thread t3 = new Thread(new Runnable() {

            public void run() {
                for(int i=0;i<10;i++) {
                    System.out.println(this.getClass()+ " index: " + i);

                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException ie) {
                        System.out.println("Error: " + ie.getMessage());
                    }
                }
            }
        });
        t3.start();

        for(int i=0;i<10;i++) {
            System.out.println("Main thread --- Index: " + i);
            Thread.sleep(1000);
        }

    }
}
