package csv;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class JsonToCsv {

public static void main(String[] args) {

	String filePath="D:\\inteli\\Jsonfolder\\jsonfile.json";
	readJson(filePath);
}
public static void readJson(String filePath) {

	try(BufferedReader bf=new BufferedReader(new FileReader(filePath))){
		String line="";
		String Json="";
		while((line=bf.readLine())!=null) {
			Json+=line;
		}
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter name for new csv file : ");
		String csvName=scan.next();
		convertJsonToCsv(Json,csvName);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {

		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
public static void convertJsonToCsv(String Json,String csvFileName) {
	try(FileWriter fw=new FileWriter("D:\\inteli\\csvfolder\\"+csvFileName+".csv")){
		fw.write("name,age,area\n");
		Json=Json.substring(1, Json.length()-1);
		String[] records=Json.split("\\},\\s*\\{");
		for(String record : records) {
			String[] fields=record.split(",");
			String name=fields[0].split(":")[1].replaceAll("\"","").trim();
			int age=Integer.parseInt(fields[1].split(":")[1].replaceAll("\"","").trim());
			String area=fields[2].split(":")[1].replaceAll("\"", "").trim();
			fw.write(name+","+age+","+area+"\n");
		}
		System.out.println("Csv file created...\nFileName:"+csvFileName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}