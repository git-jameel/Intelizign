package workout;

public class ThreadingDemo extends Thread {

	public static void main(String[] args) {
		System.out.println("Main thread is running....");
		Thread mt = Thread.currentThread();
		System.out.println(mt);
		ThreadingDemo td = new ThreadingDemo();
		Thread tt = new Thread(td,"demothread");
		tt.start();
		int act1 = Thread.activeCount();
		System.out.println("Active thread main method: " + act1);
		
		System.out.println(tt.getName());
		tt.setName("newdemothread..");
		System.out.println(tt.getName());
		int act2 = Thread.activeCount();
		System.out.println(act2);
		
	}
		
public void run() {
	Thread nt = Thread.currentThread();
	System.out.println(nt);
	System.out.println("New thread1 is running \n im in run method....");
	
}
}
