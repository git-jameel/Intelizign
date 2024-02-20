package workout;

import java.util.InputMismatchException;
import java.util.Scanner;

//public class ExceptionHandling {
//private static Scanner scan = new Scanner(System.in);
//	public static void main(String[] args) {
//		practice();
//
//	}
//	public static void practice()
//	{
//		try {
//		System.out.println("Enter dividend and the divisor for division");
//		int n1 = scan.nextInt();
//		int n2 = scan.nextInt();
//		int div = n1/n2;
//		System.out.println(n1+"/"+n2+" = "+div);
//		}
//		catch(ArithmeticException e){
//			e.printStackTrace();
//			System.out.println("divisor must not be 0 ....");
//		}
//		catch(InputMismatchException e) {
//			e.printStackTrace();
//			System.out.println("enter only numbers...");
//		}
//	}
//
//}

import java.util.Scanner;

class CannotBeNegativeException extends Exception {   //custom exception class
    public CannotBeNegativeException(String message) {
        super(message);
    }
    public CannotBeNegativeException() {}
}

public class ExceptionHandling {
    public static void main(String[] args) throws CannotBeNegativeException{
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your age...");
            int age = scan.nextInt();
            if (age < 0) {
                throw new CannotBeNegativeException("Age cannot be negative....");
            }
            else if (age<18){
            	System.out.println("You should wait for"+(18-age)+" years for voting");
            }
            else
            {
            	System.out.println("You are eligible for voting....");
            }
        } catch (CannotBeNegativeException e) {
        	e.printStackTrace();
            System.err.println(" caught: " + e.getMessage());
        }
    }

}

