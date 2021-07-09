package MultiThread;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        potok potok = new potok();
        potok potok2 = new potok();
        potok2.start();
        potok.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        potok.stopRunning();
    }

    static class potok extends Thread {
        private volatile boolean running = true;

        public void run() {
            while(running = true){
                    System.out.println("Hello My dear dear Friend");
            }
         }
        public  void stopRunning(){
            this.running = false;
        }
    }
}

