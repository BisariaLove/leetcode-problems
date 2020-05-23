package multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
    public static void main(String[] args)  throws InterruptedException {
        final Runner2 runner2  = new Runner2();

        Thread t1 = new Thread(new Runnable(){
            public void run(){
                try{
                    runner2.firstThread();
                } catch(InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try{
                    runner2.secondThread();
                } catch(InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        runner2.finished();
    }
}


class Runner2 {
    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    boolean gotFirstLock = false;
    boolean gotSecondLock = false;

    public void acquireLock(Lock lock1, Lock lock2) throws InterruptedException {
        while(true) {
            try{
                gotFirstLock = lock1.tryLock();
                gotSecondLock = lock2.tryLock();
            } finally {

                if(gotFirstLock && gotSecondLock) {
                    return;
                }
                if(gotFirstLock) {
                    lock1.unlock();
                }
                if(gotSecondLock) {
                    lock2.unlock();
                }
            }
            Thread.sleep(1000);
        }

    }

    public void firstThread() throws InterruptedException {
        Random random = new Random();

        for(int i=0; i<100; i++) {
            acquireLock(lock1, lock2);
            try{
                Account.transfer(acc1, acc2, random.nextInt(100));
            }
            finally {
                lock1.unlock();
                lock2.unlock();
            }
        }

    }

    public void secondThread() throws InterruptedException {
        Random random = new Random();

        for(int i=0; i<100; i++) {
            acquireLock(lock1, lock2);
            try{
                Account.transfer(acc2, acc1, random.nextInt(100));
            } finally {
                lock2.unlock();
                lock1.unlock();
            }

        }

    }

    public void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total Balance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}

class Account {

    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}