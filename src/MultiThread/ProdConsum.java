package MultiThread;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdConsum {
    static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                prod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread1 = new Thread(() -> {
            try {
                Consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread1.start();

        thread1.join();
        thread.join();

    }
    private static void prod() throws InterruptedException {
         boolean toto = true;
        Random random = new Random();
   while (toto)
            blockingQueue.put(random.nextInt(100));
        }
    private static void Consumer() throws InterruptedException {
        while (true) {

            System.out.println(": "+blockingQueue.take());
            System.out.println("Size: "+blockingQueue.size());
        }
        }
    }
