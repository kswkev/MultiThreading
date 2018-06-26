package udemy.javaMultithreading.tutorial003;


//{@code synchronized} ("only let one thread in here at a time".) and {@code join} ("wait until
//        * thread on which join has called finished") keyword.
public class JoiningAndSynchronizeThreads {

    private int count = 0;
    
    public static void main(String[] args) {
        JoiningAndSynchronizeThreads worker = new JoiningAndSynchronizeThreads();
        worker.doWork();
    }
    
    //synchronized keyword only allows 1 thread to execute this code at a time
    public synchronized void increment() throws InterruptedException {
        count++;
    } 

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    try {
                        increment();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<10000; i++) {
                    try {
                        increment();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                
            }
        });
        
        t1.start();
        t2.start();
        
        //halts current thread execution (main) until other thread has completed (t1)
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //without synchronized method, count can return a random number below 20000
        System.out.println("Count is: " + count);
    }
}
