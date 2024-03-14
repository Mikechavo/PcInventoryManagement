import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataStorageManager {
    private static final String FILE_PATH = "inventory.json";

    // Method to save inventory data to a file
    public void saveInventory(Part[] parts) {
     try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
         ObjectMapper objectMapper = new ObjectMapper();
         objectMapper.writeValue(fileWriter, parts);
     } catch (IOException e) {
         e.printStackTrace();
         // Handle the exception gracefully
     }
 }

    // Method to load inventory data from a file
    public Part[] loadInventory() {
     try {
         File file = new File(FILE_PATH);
         if (!file.exists()) {
             return new Part[0];
         }
         ObjectMapper objectMapper = new ObjectMapper();
         return objectMapper.readValue(file, Part[].class);
     } catch (IOException e) {
         e.printStackTrace();
         // Handle the exception gracefully
         return new Part[0];
     }
 }
 

    // Add other methods for CRUD operations, data validation, error handling, etc.
}
