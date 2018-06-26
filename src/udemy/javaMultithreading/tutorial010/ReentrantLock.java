package udemy.javaMultithreading.tutorial010;

import udemy.javaMultithreading.tutorial009.Processor;

public class ReentrantLock {

    public static void main(String[] args) throws InterruptedException {

        final Runner runner = new Runner();
        
        Thread t1 = new Thread (new Runnable() {

            @Override
            public void run() {
                try {
                    runner.firstThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        
        Thread t2 = new Thread (new Runnable() {

            @Override
            public void run() {
                try {
                    runner.secondThread();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }                
            }
            
        });
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
        
        runner.finished();
    }

}
