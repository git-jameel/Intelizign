package csv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReadCSVFile {
    public static void main(String[] args) {
        String csvFilePath = "D:\\inteli\\csvfolder\\csvFile1.csv";
        
        Map<String, String[]> csvData = new HashMap<>();
        String[] headers = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
       
            headers = reader.readLine().split(",");
           // System.out.println("Header array : " + Arrays.toString(headers));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                //
                System.out.println("Values array : " + Arrays.toString(values));
                csvData.put(values[0], values); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     
        for (Map.Entry<String, String[]> entry : csvData.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Values: ");
            String[] values = entry.getValue();
            for (int i = 0; i < values.length; i++) {
                System.out.println( "\t "+headers[i] + ": " + values[i]);
            }
            System.out.println();
        }
    }
}
