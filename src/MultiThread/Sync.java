package MultiThread;

public class Sync {
    private int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Sync test = new Sync();
        test.doSomething();

    }
    public  synchronized void doSomething() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10000; i++)
                    counter++;
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10000; i++)
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
