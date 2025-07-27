package view;
import java.io.File;
import java.util.List;
import java.util.Scanner;

import controller.ConflictHandler;
import controller.FileHandler;
import model.Instruction;

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
        //int cycles1 = 0;

        if (file.isFile()) {
          List<Instruction> instructions = FileHandler.read(file.getAbsolutePath());
          
          //cycles1 = getCycles1;
          //cycles2 = getCycles2;


          cycles = ConflictHandler.readInstructions(instructions).size();
          //cycles += instructions.size() + bubbles + 4;
        } else {
          System.err.println("\u001B[31mFailed to read " + file.getName() + ": is not a file.\u001B[0m");
        }
        //System.out.println("Total de ciclos sem adiantamento de dados: "+ cycles1);
        //System.out.println("Total de ciclos com adiantamento de dados: "+ cycles2);
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
