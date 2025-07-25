import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  public static List<Instruction> read(String filePath) throws IOException {
    File file = new File(filePath);
    ArrayList<Instruction> instructions = new ArrayList<>();

    if (!file.canRead()) {
      throw new IOException("Cannot read file " + file.getName());
    }

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;

      while ((line = br.readLine()) != null) {
        instructions.add(new Instruction((line.split("[,\\s()]+"))));
      }
    } catch (IOException e) {
      throw new IOException("Failed to read the file " + e.getMessage());
    }

    return instructions;
  }
}
