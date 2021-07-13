package MultiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RentLock {
    public static void main(String[] args) throws InterruptedException {
         Task task = new Task();


            Thread thread1 = new Thread(() -> {
                task.fistThread();
            });
            Thread thread2 = new Thread(() -> {
                task.secondThread();
            });

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

        System.out.println(task.counter);
    }
    static class Task {
        private int counter;
        private Lock lock = new ReentrantLock();

        private void increment(){
            for (int i = 0; i<1000; i++){
                counter++;
            }
        }

        private void fistThread() {
            lock.lock();
            increment();
            lock.unlock();
        }

        private void secondThread() {
            lock.lock();
            increment();
            lock.unlock();
        }
    }
}

