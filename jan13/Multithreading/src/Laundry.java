import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.lang.Thread;
import java.util.Arrays;
import java.util.List;

public class Laundry {
    public static Lock washLock = new ReentrantLock();
    public static Lock dryerLock = new ReentrantLock();
    public static Lock folderLock = new ReentrantLock();
    
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Carol");

    //     for (String name : names) {
    //         Load load = new Load(String.format("%s's Laundry", name));

    //         Thread wash = new Thread(new WasherTask(load));
    //         Thread dry = new Thread(new DryerTask(load));
    //         Thread fold = new Thread(new FolderTask(load));

    //         wash.start();
    //         dry.start();
    //         fold.start();
    //     }

        for (String name : names) {
            (new LoadThread(String.format("%s's Laundry", name))).start();
        }

        (new LoadThread(String.format("%s's Laundry", "Dave"), "washed")).start();
    }        
}

class LoadThread extends Thread {
    private Load load;
    
    public LoadThread(String loadName) {
        this.load = new Load(loadName);
    }

    public LoadThread(String loadName, String status) {
        this.load = new Load(loadName, status);
    }

    @Override
    public void run() {
        if (load.getStatus().equals("dirty")) {
            WasherTask wash = new WasherTask(this.load);
            wash.run();
        }
        
        if (load.getStatus().equals("washed")) {
            DryerTask dry = new DryerTask(this.load);
            dry.run();
        }

        if (load.getStatus().equals("dried")) {
            FolderTask fold = new FolderTask(this.load);
            fold.run();
        }
    }
}

class Load {
    private String id;
    private String status = "dirty";

    public Load(String id) {
        this.id = id;
    }

    public Load(String id, String status) {
        this.id = id;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class WasherTask implements Runnable {
    private Load currLoad;
    
    public WasherTask(Load currLoad) {
        this.currLoad = currLoad;
    }

    @Override
    public void run() {
        
        Laundry.washLock.lock();
        
        System.out.println(
            String.format(
                "%s using washer!",
                currLoad.getId()
            )
        );

        try {
            Thread.sleep(3000);
            currLoad.setStatus("washed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        
        System.out.println(
            String.format(
                "%s finished washing!",
                currLoad.getId()
            )
        );

        Laundry.washLock.unlock();
    }
}

class DryerTask implements Runnable {
    private Load currLoad;

    public DryerTask(Load currLoad) {
        this.currLoad = currLoad;
    }
    
    @Override
    public void run() {
        
        Laundry.dryerLock.lock();
        
        System.out.println(
            String.format(
                "%s using dryer!",
                currLoad.getId()
            )
        );

        try {
            Thread.sleep(5000);
            currLoad.setStatus("dried");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Laundry.dryerLock.unlock();

        System.out.println(
            String.format(
                "%s finished drying!",
                currLoad.getId()
            )
        );
    }
}

class FolderTask implements Runnable {
    private Load currLoad;
    
    public FolderTask(Load currLoad) {
        this.currLoad = currLoad;
    }
    @Override
    public void run() {
        
        Laundry.folderLock.lock();
        
        System.out.println(
            String.format(
                "%s using folder!",
                currLoad.getId()
            )
        );

        try {
            Thread.sleep(1000);
            currLoad.setStatus("folded");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(
            String.format(
                "%s finished folding!",
                currLoad.getId()
            )
        );

        Laundry.folderLock.unlock();

    }
}