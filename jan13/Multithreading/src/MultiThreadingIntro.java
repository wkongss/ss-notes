import java.lang.Thread;

public class MultiThreadingIntro {

    // Threads allow for a program to make parallelized use of resources (i.e. CPU cores).
    // Allocation is based on architecture/system.
    // No order is guaranteed as a task finishes.

    // Thread life cycle:
    // NEW (created and initialized)
    // Transitions into the following states that transition between each other:
    // RUNNABLE (active after a thread.start())
    // BLOCKED (idle waiting for a lock on a shared resource)
    // WAITING (idle indefnitely waiting for a condition like a join)
    // WAITING-TIME (idle for a set time period like a Thread.sleep())
    // Transitions into:
    // TERMINATED (finished running)

    public static void main(String[] args) {
        // Get main thread that the entry point runs on.
        // Thread mainThread = Thread.currentThread();

        Task task1 = new Task("t1");
        Task task2 = new Task("t2");
        Task task3 = new Task("t3");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);
        
        thread1.start();
        thread2.start();
        thread3.start(); 
    }
}

// One way to create a runnable task is to implement the runnable interface
// Runnable is a functional interface, meaning it only contains one method to implement.
class Task implements Runnable {
    private String taskName = "default task";

    public Task() {

    }

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s has started! System name: %s", this.taskName, Thread.currentThread().getName()));
        
        try {
            Thread.sleep(2000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(String.format("%s has ended! System name: %s", this.taskName, Thread.currentThread().getName()));
    }
}