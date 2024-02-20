package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FlatMapDemo {
	static int i=1;
public static void main(String[] args) {
	
	List <Integer> age = Arrays.asList(90,45,22,20);
	List <String> name = Arrays.asList("mabu","niya","bash","jame");
	List <List<?>>lol = Arrays.asList(age,name);
	lol.stream().flatMap(n->n.stream()).forEach(s->
	{
		System.out.println(i++ +" : "+s);
	});
	
}
}
