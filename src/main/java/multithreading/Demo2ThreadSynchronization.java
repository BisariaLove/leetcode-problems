package multithreading;

import java.util.Scanner;

class Processor extends Thread {

    private boolean running = true;

    public void run() {
        while(running) {

            System.out.println("Hello + " + this.getName());

            try{
                Thread.sleep(1000
                );
            } catch(Exception e) {
             e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running=false;
    }
}


public class Demo2ThreadSynchronization {

    public static void main(String args[]) {
        Processor proc1 = new Processor();
        proc1.start();



        System.out.println("Press return to Stop....");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();
    }
}
