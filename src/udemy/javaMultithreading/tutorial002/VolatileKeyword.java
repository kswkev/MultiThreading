package udemy.javaMultithreading.tutorial002;

import java.util.Scanner;

class Processor extends Thread {

    //the volatile keyword stops java from cacheing the value of this field, in some cases if volatile is not used the while 
    //loop will never recheck the value of running
    //the volatile modifier guarantees that any thread that reads a field will see the most recently written value
    private volatile boolean running = true;
    
    @Override
    public void run() {
        while (this.running) {
            System.out.println("Running");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void shutdown() {
        this.running = false;
    }
    
}

public class VolatileKeyword {

    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();
        System.out.println("Enter something to stop the thread,\nVolatile variable running will be forced to true :");
        new Scanner(System.in).nextLine();
        processor.shutdown();
    }

}
