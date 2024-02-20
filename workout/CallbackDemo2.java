package workout;

interface CallbackInterface {
    void onComplete();
}

class SynchronousTask {
    void execute(CallbackInterface callback) {
        System.out.println("Starting synchronous task...");
        // Simulate a long-running task
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Synchronous task complete.");
       
        callback.onComplete();
    }
}

class AsynchronousTask {
    void execute(CallbackInterface callback) {
        System.out.println("Starting asynchronous task...");
        new Thread(() -> {
            // Simulate a long-running task
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Asynchronous task complete.");
            callback.onComplete();
        }).start();
    }
}

public class CallbackDemo2 {
    public static void main(String[] args) {
    	CallbackInterface callback = () -> System.out.println("Callback complete.");
        SynchronousTask syncTask = new SynchronousTask();
        AsynchronousTask asyncTask = new AsynchronousTask();
        // Execute synchronous task
        syncTask.execute(callback);
        // Execute asynchronous task
        asyncTask.execute(callback);
    }
}
