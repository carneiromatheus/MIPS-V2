import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

public class FileHandler {

  private FileHandler() {
  }

  public static File[] listFiles(String directoryPath, String filenamePattern) {
    File directory = new File(directoryPath);

    if (!directory.exists() || !directory.isDirectory()) {
      throw new IllegalArgumentException("Invalid directory path " + directoryPath);
    }

    File[] files = directory
        .listFiles((dir, filename) -> filename.matches(filenamePattern) && new File(dir, filename).isFile());

    if (files == null || files.length == 0) {
      throw new IllegalStateException("No matching files found in directory " + directoryPath);
    }

    return files;
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
