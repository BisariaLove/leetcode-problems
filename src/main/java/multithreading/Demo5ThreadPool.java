package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Runner1 implements Runnable {
   int id;

   public Runner1(int id) {
       this.id = id;
   }
    public void run() {
        System.out.println("Started: " + id);

        try{
            Thread.sleep(500);
        } catch(InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Completed: " + id);
    }

}
public class Demo5ThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i=0; i<5; i++) {
            executorService .submit(new Runner1(i));
        }

        executorService.shutdown();

        System.out.println("All tasks submitted.");

        try{
            executorService.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }
}
