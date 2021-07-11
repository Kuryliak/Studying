package MultiThread;

public class Sync {
    private int counter = 0;
    Object LOCK = new Object();
    Object LOCK1 = new Object();
    public static void main(String[] args) throws InterruptedException {
        Sync test = new Sync();
        test.doSomething();

    }
    public  synchronized void doSomething() throws InterruptedException {
        Thread thread = new Thread(() -> {
            synchronized (LOCK) {
                for (int i = 0; i < 10000; i++)
                    counter++;
            }
        });
        Thread thread1 = new Thread(() -> {
            synchronized (LOCK1) {
                for (int i = 0; i < 10000; i++)
                    counter++;
            }
        });

        thread.start();
        thread1.start();

        thread1.join();
        thread.join();

        System.out.println(counter);
    }

}
