import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;
import java.lang.Thread;

public class ProducerConsumer {
    public static void main(String[] args) {
        // Producer generates data (i.e. via API calls, DB queries) and puts it in a shared collection
        // Consumer then takes this produced data and processes it
        // Generally done through via multithreaded via a concurrent collcection
        // Without concurrent collections, you have to use 
        // synchronized (collection) {
        // ...
        // }
        // blocks and collection.wait() and collection.notify(thread)/collection.notifyAll() to synchronize your collection.

        final Queue<Integer> stringQueue = new ConcurrentLinkedQueue<>(); // final makes sure queue is a fixed size.
        final int CAPACITY = 5; // final means capacity is fixed
        final int PRODUCTION_LIMIT = 20_000;

        // Define producerThread with an anonymous inner class
        // Able to do this because Runnable is a functional interface
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i <= PRODUCTION_LIMIT) {
                    if (stringQueue.size() < CAPACITY) {
                        System.out.println(String.format("Produced %d", i));
                        stringQueue.add(i++);
                    }
                }
            }
        });

        // Define consumerThread with a lambda function
        // Able to do this because Runnable is a functional interface
        Thread consumerThread = new Thread(() -> {
            int i = 0;
            while (i <= PRODUCTION_LIMIT) {
                if (!stringQueue.isEmpty()) {
                    int val = stringQueue.poll();
                    System.out.println(String.format("Consumed %d", val));
                    i++;
                }
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}