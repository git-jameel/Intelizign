package streams;

public class LamdaClass {
	public static void main(String[] args) {
		Printable p = (a,b)->{
			System.out.println(a+" "+b);
			return a+" "+b;
		};
		p.print("jameel","afsar");
	
	}

}
interface Printable{
	String print(String a, String b);
}
