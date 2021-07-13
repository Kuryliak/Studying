package MultiThread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();


        Thread thread = new Thread(() -> {
            runner.fistThread();
        });
        Thread thread2 = new Thread(() ->{
            runner.secondThread();
        });

        thread.start();
        thread2.start();


        thread.join();
        thread2.join();

        runner.finished();


    }

    static class Runner {
        private Account account1 = new Account();
        private Account account2 = new Account();
        private Lock lock1 = new ReentrantLock();
        private Lock lock2 = new ReentrantLock();

        Random random = new Random();

         public void fistThread() {

             for (int i = 0; i < 10000; i++) {
                 lock1.lock();
                 lock2.lock();
                         Account.transfer(account1, account2, random.nextInt(100));
                         lock1.unlock();
                         lock2.unlock();
                     }
                 }
        public void secondThread() {
            for (int i = 0; i < 10000; i++) {
                lock1.lock();
                 lock2.lock();
                Account.transfer(account2, account1, random.nextInt(100));
                lock1.unlock();
                lock2.unlock();
                    }
                }
        public void finished(){
            System.out.println(account1.getBalance());
            System.out.println(account2.getBalance());
            System.out.println("Total : "+ (account1.getBalance()+account2.getBalance()));

        }
    }
}class Account{
    private  int balance = 10000;

    public void deposit(int amount){
        balance += amount;
    }
    public void withdraw(int amount){
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
    public static void transfer(Account account1, Account account2, int amount){
           account1.withdraw(amount);
           account2.deposit(amount);
    }
}
