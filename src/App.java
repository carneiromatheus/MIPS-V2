import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Informe o caminho do diretório dos arquivos TESTES-XX.txt: ");
    String path = sc.nextLine().trim();
    String filenamePattern = "TESTE-\\d{2}\\.txt";

    try {
      File[] files = FileHandler.listFiles(path, filenamePattern);

      for (File file : files) {
        System.out.println("File found:" + file.getName());
        int cycles = 0;

        if (file.isFile()) {
          List<ArrayList<String>> instructions = FileHandler.read(file.getAbsolutePath());
          int bubbles = ConflictHandler.check(instructions);

          cycles += instructions.size() + bubbles + 4;
        } else {
          System.err.println("\u001B[31mFailed to read " + file.getName() + ": is not a file.\u001B[0m");
        }

        System.out.println("Total de ciclos: " + cycles);

        String filePath = new File(file.getParentFile(),
            "Augusto e Matheus Carneiro"
                + File.separator
                + file.getName().replace(".txt", "-RESPOSTA.txt"))
            .getPath();

        FileHandler.write(filePath, String.valueOf(cycles));
        System.out.println("Writing output to: " + filePath);
      }
    } catch (Exception e) {
      System.err.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
    } finally {
      sc.close();
    }
  }
}
