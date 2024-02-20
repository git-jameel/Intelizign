package workout;

public class MultiThreadDemo implements Runnable{
	String task;	
	MultiThreadDemo(String mask){
		task = mask;
	}
	public static void main(String[] args) {
		System.out.println("Cleaning the House scenario!!!");
		MultiThreadDemo mt1 = new MultiThreadDemo("Cleaning the HALL");
		MultiThreadDemo mt2 = new MultiThreadDemo("Cleaning the BEDROOM");
		MultiThreadDemo mt3 = new MultiThreadDemo("Cleaning the KITCHEN");
		Thread t1 = new Thread(mt1,"hall");
		Thread t2 = new Thread(mt2,"bedroom");
		Thread t3 = new Thread(mt3,"kitchen");
		t1.start();
		t2.start();
		t3.start();
		//System.out.println("House is clean now...");
	}
	public void run() {
		for(int i=1;i<=3;i++) {
			System.out.println(task+" :"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
}
