package threadScheduling;

class Business {
    private int intiValue;
    private boolean produced = false;

    public synchronized void produce(int value) {
        while (produced) {
            try {
                System.out.println("Producer: Item already produced, waiting...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        intiValue = value;
        System.out.println("Producer: Produced item " + value);
        produced = true;
        notify(); 
    }

    public synchronized void consume() {
        while (!produced) {
            try {
                System.out.println("Consumer: No item produced yet, waiting...");
                wait(); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Consumer: Consumed item " + intiValue);
        produced = false;
        notify(); 
    }
}

class Producer implements Runnable {
    private final Business business;

    public Producer(Business business) {
        this.business = business;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
        	business.produce(i);
        }
    }
}

class Consumer implements Runnable {
    private final Business business;

    public Consumer(Business b) {
        this.business = b;
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++) {
        	business.consume();
        }
    }
}

public class WaitExample {
    public static void main(String[] args) {
    	Business sharedResource = new Business();

      
        Thread producerThread = new Thread(new Producer(sharedResource), "ProducerThread");
        Thread consumerThread = new Thread(new Consumer(sharedResource), "ConsumerThread");

        
        producerThread.start();
        consumerThread.start();
    }
}

