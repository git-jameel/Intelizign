package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo2 {

	public static void main(String[] args) {
		List <Student> al = 
		  Arrays.asList(new Student(1,"basheex",21,20000),
						new Student(2,"niyax",24,30000),
						new Student(3,"mabux",27,40000),
						new Student(4,"suthix",11,50000));
		
		 al.stream()
		 .filter(p->p.age>10)
		 .sorted(Comparator.comparing(s -> s.age))
		 .forEach(n->System.out.println(n));
	 
		 al.stream().map(n->n.fees=n.fees-10000)
		 .forEach(n->System.out.println(n));
		 
		 al.stream()
		 .map(n->{
			 n.name=changeCase(n.name);
			 return n;
			 })
		 .forEach(System.out::println);
	//List<Student> fees = 	 al.stream().sorted(Comparator.comparingDouble(s->s.fees).reversed()).collect(Collectors.toList());
		
		
	}
	static String changeCase(String s) {
		return s.toUpperCase();
	}

}
class Student{
	int rollno;
	String name;
	int age;
	double fees;
	public Student(int rollno, String name, int age, double fees) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
		this.fees = fees;
	}
	public String toUpperCase() {
		// TODO Auto-generated method stub
		return null;
	}
	public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", fees=" + fees +
                '}';
    }

}
