import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Informe o caminho do diretório dos arquivos TESTES-XX.txt: ");
    String path = "/home/augusto-henrique/Documents/Estudos/BSI/2025_03/ARQUITETURA DE COMPUTADORES/teste"; //sc.nextLine();
    String filenamePattern = "TESTE-\\d{2}\\.txt";

    try {
      File[] files = FileHandler.listFiles(path, filenamePattern);

      for (File file : files) {
        if (file.isFile()) {
          List<Instruction> instructions = FileHandler.read(file.getAbsolutePath());
          System.out.println(file.getName() /*+ " instructions:" + instructions*/);
          ConflictHandler.clockCicles(instructions);

          // EXPLAIN: Estamos pegando as instruções do arquivo e armazenando em uma Matriz

          // Exemplo: TESTE-01.txt
          // [
          //   [lw, $t0, 1200, $t1],
          //   [add, $t0, $s2, $t0],
          //   [sw, $t0, 1200, $t1]
          // ]

          // Processar as instruções de acordo com o opcode
          // ...

          // FIX: Limpar comentários acima
        } else {
          System.err.println("\u001B[31mFailed to read " + file.getName() + ": is not a file.\u001B[0m");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.err.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
    } finally {
      sc.close();
    }
  }
}
