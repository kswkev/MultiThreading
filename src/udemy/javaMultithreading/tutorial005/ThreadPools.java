package udemy.javaMultithreading.tutorial005;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements  Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }
    
    public void run() {
        System.out.println("Starting: " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
        System.out.println("Completed: " + id);
    }
    
}

public class ThreadPools {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for (int i=0; i<5; i++) {
            executorService.submit(new Processor(i));
        }
        
        executorService.shutdown();
        System.out.println("All tasks submitted.");
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException ignored) {
        }
        System.out.println("All tasks completed.");
    }

}
