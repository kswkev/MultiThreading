package udemy.javaMultithreading.tutorial009;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

    private final int LIMIT = 10;
    
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private Object lock = new Object();
    
    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
              //whenever the thread is notified starts again from the loop
                while (list.size() == LIMIT) {
                    lock.wait();
                }
                
                list.add(value++);
            }
        }
    }
    
    public void consume() throws InterruptedException {
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    lock.wait();
                }
                
                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value); 
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000)); //force producer fill the queue to LIMIT_SIZE
        }
    }
}
