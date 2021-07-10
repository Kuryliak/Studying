package MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolClass {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i = 0; i<100; i++){
            executorService.submit(new Work(i));
        }
        executorService.shutdown();

        executorService.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("Work completed");

    }
    static class Work implements Runnable{
        private int id;

        public Work(int id){
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Work "+id +" completed");
        }
    }
}
