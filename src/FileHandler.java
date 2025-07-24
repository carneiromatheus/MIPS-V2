import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class FileHandler {

  private FileHandler() {
  }

  public static File[] listFiles(String directoryPath) {
    File directory = new File(directoryPath);
    if (!directory.exists() || !directory.isDirectory()) {
      throw new IllegalArgumentException("Invalid directory path " + directoryPath);
    }

    return directory.listFiles();
  }

  public static void read(String filePath) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;

      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      throw new IOException("Error reading file " + e.getMessage());
    }
  }
}
