package threadScheduling;
class YieldExample implements Runnable {

    private final String name;

    public YieldExample(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <=3; i++) {
            System.out.println(name + ": " + i);
            Thread.yield(); 
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        Thread t1 = new Thread(new YieldExample("Thread 1"));
        Thread t2 = new Thread(new YieldExample("Thread 2"));
        Thread t3 = new Thread(new YieldExample("Thread 3"));
        Thread t4 = new Thread(new YieldExample("Thread 4"));
        
        t1.setPriority(1);
        t2.setPriority(10);
        t3.setPriority(5);
        t4.setPriority(5);

      
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
