package udemy.javaMultithreading.tutorial001;

//method 2 for implementing a thread class, implement a Runnable class, override run method
class RunnerImpl implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<10; i++) {
            System.out.println("Hello " + i);
            
            try {
                //causes the thread to wait for x miliseconds
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}

//create a new Thread and pass Runnable implementation as constructor param
public class ImplementRunnable {

    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnerImpl());
        t1.start();
        Thread t2 = new Thread(new RunnerImpl());
        t2.start();
        
        //Can also be done like so:
        Thread t3 = new Thread (new Runnable() {

            @Override
            public void run() {
                for (int i=0; i<10; i++) {
                    System.out.println("Hello " + i);
                    
                    try {
                        //causes the thread to wait for x miliseconds
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        });
        
        t3.start();
    }

}
