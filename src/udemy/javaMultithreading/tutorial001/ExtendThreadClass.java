package udemy.javaMultithreading.tutorial001;


//method 1 for implementing a thread class, extend Thread, override run method
class Runner extends Thread {

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

//instanciate the class and call start() method, which in turn calls the overridded run method
public class ExtendThreadClass {

    public static void main(String[] args) {
        Runner r1 = new Runner();
        r1.start();
        
        Runner r2 = new Runner();
        r2.start();
    }

}
