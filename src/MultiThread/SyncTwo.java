package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SyncTwo {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        worker.main();

    }

    static  class Worker {
        Object lock = new Object();
        Object lock1 = new Object();


        Random random = new Random();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        public  void addToList() {
            synchronized (lock) {
                list1.add(random.nextInt(100));
            }
        }

        public  void addToList2() {
            synchronized (lock1) {
                list2.add(random.nextInt(100));
            }
        }

        public void main() throws InterruptedException {
            long before = System.currentTimeMillis();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    work();
                }
            });
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    work();
                }
            });



            thread.start();
            thread1.start();

            thread1.join();
            thread.join();
            long After = System.currentTimeMillis();
            System.out.println("took " + (After - before) + "ms");

            System.out.println(list1.size());

            System.out.println(list2.size());
        }
        public  void work(){
            for (int i = 0; i<1000; i++){
                addToList();
                addToList2();
            }
        }
    }
}


