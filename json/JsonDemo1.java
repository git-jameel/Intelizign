package json;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonDemo1 {
    public static void main(String[] args) {
        try {
           
            BufferedReader reader = Files.newBufferedReader(Paths.get("D:\\inteli\\Jsonfolder\\jsonfile.json"));

            
            StringBuilder jsonContentBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContentBuilder.append(line);
            }

            String jsonString = jsonContentBuilder.toString();
            
            System.out.println("JSON String: " + jsonString);

            String name = extractValue(jsonString, "name");
            String age = extractValue(jsonString, "age");
            String area = extractValue(jsonString, "area");

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Area: " + area);

            
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractValue(String jsonString, String key) {
        int startIndex = jsonString.indexOf('\"' + key + "\":") + key.length() + 3;
        System.out.println("SI :"+startIndex);
        int endIndex = jsonString.indexOf('"',startIndex);
        System.out.println("EI :"+endIndex);
        return jsonString.substring(startIndex, endIndex);
    }
}
