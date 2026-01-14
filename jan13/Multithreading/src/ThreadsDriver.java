import java.lang.Thread;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadsDriver {
    // Volatile keyword allows for non-blocking behavior; however, this sacrifices atomnicity of transactions
    // Threads can read amd write a stale value (i.e. another thread is the middle of a write)
    // Static keyword ensures the reference is shared across the class
    private static volatile int volatileCount = 0;

    // Atomic: transactions are done all at once or not at all
    // java.util.concurrent.atomic library provides atomic, thread-safe types
    // methods are thread-safe by default.
    private static AtomicInteger atomicCount = new AtomicInteger(0);
    
    public static void increment() {
        volatileCount++;
        atomicCount.incrementAndGet();
    }

    public static void main(String[] args) {
        int loops = 10_000_000;
        Thread thread1 = new MyThread(loops);
        Thread thread2 = new MyThread(loops);

        System.out.println(String.format("Volatile Count: %d, Atomic Count: %d", volatileCount, atomicCount.get()));
        
        thread1.start();
        thread2.start();
        
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("Volatile Count: %d, Atomic Count: %d", volatileCount, atomicCount.get()));
    }
}

// You can also do concurrency by overwriting the run() method of
// a Thread subclass
class MyThread extends Thread {
    private int loops = 0;

    public MyThread() {
        super();
    }

    public MyThread(int loops) {
        super();
        this.loops = loops;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s has started!", Thread.currentThread().getName()));

        for (int i = 0; i < this.loops; i++) {
            ThreadsDriver.increment();
        }

        System.out.println(String.format("%s has ended!", Thread.currentThread().getName()));
    }
}