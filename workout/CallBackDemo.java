package workout;

public class CallBackDemo {

	public static void main(String[] args) {
		Labour lab = new Labour();
		lab.doWork(new CallBack1());
		lab.doWork(new CallBack2());
	}

}
class Labour{
	public void doWork(Callback b) {
		
		System.out.println("Work Started..");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.onFinish();
		b.onFinish();
	}
}
interface Callback{
	public void onFinish();
}
class CallBack1 implements Callback{
	@Override
	public void onFinish() {
		System.out.println("Work done sucessfully... by 1st class");
	}
}

class CallBack2 implements Callback{
	@Override
	public void onFinish() {
		System.out.println("work done successfully ... by 2nd class");
		
}
}

