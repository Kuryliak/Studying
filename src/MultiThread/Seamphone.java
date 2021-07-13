package MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Seamphone {
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Connection connection = Connection.getConnection();

           for (int i = 0; i<100; i++){
               executorService.submit(() -> {
                   try {

                       connection.work();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               });
        }
        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.MINUTES);
    }
}
class  Connection{
    private  static Connection connection  = new Connection();
    private int connections = 0;
    public Semaphore semaphore = new Semaphore(10);

    private Connection(){
        this.connection = connection;
    }

    public static Connection getConnection() {
        return connection;
    }


    public void work() throws InterruptedException {
        semaphore.acquire();
       try {
           doSometing();
       }finally {
           semaphore.release();
       }
    }
    private void doSometing() throws InterruptedException {
        synchronized (this){
            connections++;
            System.out.println(connections);
        }
        Thread.sleep(1000);
        synchronized (this){
            connections--;
        }
    }
}
