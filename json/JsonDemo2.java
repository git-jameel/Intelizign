package json;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonDemo2 {
    public static void main(String[] args) {
        // Path to your JSON file
        String jsonFilePath = "D:\\inteli\\jsonfolder\\jsonfile.json";

        try (BufferedReader br = new BufferedReader(new FileReader(jsonFilePath))) {
            StringBuilder sb = new StringBuilder();
            String line;

            // Read JSON file line by line and append to StringBuilder
            while ((line = br.readLine()) != null) {
                sb.append(line.trim());
            }

            String jsonString = sb.toString();
            System.out.println("JSON String: " + jsonString +"\n");
            // Start parsing the JSON string
            parseJson(jsonString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Parse JSON string and extract key-value pairs
    private static void parseJson(String jsonString) {
        // Remove leading and trailing square brackets if present
    	int j = 0;
        if (jsonString.startsWith("[") && jsonString.endsWith("]")) {
            jsonString = jsonString.substring(1, jsonString.length() - 1);
        }

        
        // Split JSON objects by "},{" to separate each JSON object
        String[] jsonObjects = jsonString.split("\\},\\{");
        for(int i=0;i<jsonObjects.length;i++)
        	System.out.println((i+1)+" :"+ jsonObjects[i]);
        System.out.println("\n");
        
        // Handle the first and last JSON objects separately if they don't have a comma separator
        if (jsonObjects.length > 1) {
            jsonObjects[0] = jsonObjects[0] + "}";
            jsonObjects[jsonObjects.length - 1] = "{" + jsonObjects[jsonObjects.length - 1];
        }
        
        
        
        // Extract key-value pairs from each JSON object
        for (String jsonObject : jsonObjects) {
            // Remove leading and trailing curly braces if present
            if (jsonObject.startsWith("{") && jsonObject.endsWith("}")) {
                jsonObject = jsonObject.substring(1, jsonObject.length() - 1);
            }
           
            
            
            // Split JSON key-value pairs by ","
            String[] keyValuePairs = jsonObject.split(",");
           
            
            
            // Create a new HashMap for each JSON object
            HashMap<String, String> hm = new HashMap<>();
            
            
            // Extract key-value pairs from each JSON object
            for (String pair : keyValuePairs) {
                // Split each JSON key-value pair by ":"
                String[] keyValue = pair.split(":");
               
                
                // Extract key and value
                String key = keyValue[0].trim().replaceAll("\"", "");
                String value = keyValue[1].trim().replaceAll("\"", "");
                //System.out.println(key +":"+ value);
                
                // Add key-value pair to HashMap
                hm.put(key, value);
            }
            
            // Print the HashMap for the current JSON object
            System.out.print(++j+"->");
            for (Map.Entry<String, String> entry : hm.entrySet()) {
                System.out.println("  "+entry.getKey() + " : " + entry.getValue());
            }
            System.out.println();
        }
    }
}
