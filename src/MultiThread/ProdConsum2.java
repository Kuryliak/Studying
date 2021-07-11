package MultiThread;

import java.util.LinkedList;
import java.util.Queue;

public class ProdConsum2 {
    public static void main(String[] args) throws InterruptedException {

        ProducerConsumer pr = new ProducerConsumer();

        Thread prod = new Thread(() -> {
            try {
                pr.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consum = new Thread(() -> {
            try {
                pr.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        prod.start();
        consum.start();

        prod.join();
        consum.join();
    }

} class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int limit = 10;
    private final Object lock = new Object();

    public void producer() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (queue.size() == limit) {
                    lock.wait();
                }
                queue.offer(value++);
                lock.notify();
            }
        }
    }

    public void consumer() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) {
                    lock.wait();
                }
                int value = queue.poll();
                System.out.println(value);
                System.out.println("Size of queue " + queue.size());

                lock.notify();
            }
            Thread.sleep(1000);
        }
    }
}
