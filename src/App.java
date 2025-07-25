import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the directory path to list files: ");
    String path = sc.nextLine();

    try {
      for (File file : FileHandler.listFiles(path)) {
        if (file.isFile() && file.getName().matches("TESTE-\\d{2}\\.txt")) {
          try {
            System.out.println("Reading file " + file.getName());
            FileHandler.read(file.getAbsolutePath());
          } catch (IOException e) {
            System.err.println(e.getMessage());
          }
        }
      }
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    } finally {
      sc.close();
    }
  }
}