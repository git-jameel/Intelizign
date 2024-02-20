package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class StreamsDemo1 {

	public static void main(String[] args) {
		int arr[] = {2,3,4,10,6,12,45,1,34,6,2,1};
		List <Integer> list = Arrays.asList(2,3,4,5,5,6,6,7,0,2);
		List<Integer> evenlist = new ArrayList<Integer>();
		System.out.println(Arrays.toString(arr));
		
		System.out.print("Divisible by 2 : ");
		 Arrays
		.stream(arr)
		.filter(n ->n%2==0)
		.forEach(n -> System.out.print(n+" "));
		 
		System.out.println("\nMin value : "+Arrays
			.stream(arr)
			.min());
		
		System.out.println("Max value : "+Arrays
				.stream(arr)
				.max());
		
		OptionalDouble oi =  Arrays
				.stream(arr)
				.average();
		System.out.println("Average : "+oi.getAsDouble());
		
		System.out.println("Unique values..");
			Arrays
			.stream(arr)
			.distinct()
			.forEach(n -> System.out.print(n+" "));;
		
		System.out.println("\nFirst obj : "+Arrays
		.stream(arr)
		.sorted()
		.findFirst());
		
		System.out.println("Count  : "+Arrays
				.stream(arr)
				.count());
		
		System.out.println("Count of unique elements : "+Arrays
				.stream(arr)
				.distinct()
				.count());
		
	//	evenlist=(List<Integer>) Arrays.stream(arr).filter(n->n%2==0);
		System.out.println(evenlist);
		
		Optional <Integer> opt = list.stream().min((val1,val2)->{
			return val1.compareTo(val2);
		});
		System.out.println("min"+opt);
		
		Optional <Integer> max = list.stream().max((val1,val2)->{
			return val1.compareTo(val2);
		});
		System.out.println("max"+max);
		
		list.stream().distinct().forEach(System.out::println);
		
		//Arrays.stream(arr).sorted().forEach(n->System.out.println(n));
		//Arrays.stream(arr).sorted().forEach(System.out::println);
		//Arrays.stream(arr).sorted().forEach(System.out::println);
	}

}
