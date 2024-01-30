import java.util.HashMap;
import java.io.*;

public class Users{

  private HashMap<String, Reader> readers;

  public Users{
    this.readers = new HashMap<>();
    loadReadersFromFile();
  }

  public void loadReadersFromFile() {
      String filename = "users.txt";
      try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
          String line;
          while ((line = br.readLine()) != null) {
              String[] parts = line.split(",");
              if (parts.length == 2) {
                  String name = parts[0];
                  String id = parts[1];
                  readers.put(id, new Reader(name, id));
              }
          }
      } catch (FileNotFoundException e) {
          System.err.println("Users file not found: " + e.getMessage());
      } catch (IOException e) {
          System.err.println("Error reading users file: " + e.getMessage());
      }
  }
}
