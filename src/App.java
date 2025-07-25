import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Informe o caminho do diretório dos arquivos TESTES-XX.txt: ");
    String path = sc.nextLine();
    String filenamePattern = "TESTE-\\d{2}\\.txt";

    try {
      for (File file : FileHandler.listFiles(path, filenamePattern)) {
        if (file.isFile()) {
          try {
            System.out.println("Reading file " + file.getName());
            FileHandler.read(file.getAbsolutePath());
          } catch (IOException e) {
            System.err.println(e.getMessage());
          }
        }
      }
    } catch (Exception e) {
      System.err.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
    } finally {
      sc.close();
    }
  }
}
