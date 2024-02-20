package workout;

class Dummy
{
	static int count;
	
	public synchronized void incr() {
		count++;
	}
}
public class SynchronizeDemo implements Runnable{
	Dummy d = new Dummy();
	public static void main(String[] args) throws Exception {
		
		SynchronizeDemo s1 = new SynchronizeDemo();
		Thread t1 = new Thread(s1,"1st thread..");
		SynchronizeDemo s2 = new SynchronizeDemo();
		Thread t2 = new Thread(s2,"2nd thread...");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Value of count : "+ Dummy.count);

	}
	public void run() {
		//Dummy d = new Dummy();
		for(int i=1;i<=500;i++) {
			d.incr();
		}
	}
	
	
	

}
