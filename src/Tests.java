import java.io.File;
import java.nio.file.Path;
import java.util.List;

public class Tests {
    public static void main(String[] args) {
        System.out.println("Executando teste 1");
        test1();
    }

    private static void test1() {
        String fileDirectory = "/home/augusto-henrique/Documents/Estudos/BSI/2025_03/ARQUITETURA DE COMPUTADORES/teste1";
        String fileName = "TESTE-01.txt";
        File file = new File(fileDirectory,fileName);
        try {
            List<Instruction> instructions = FileHandler.read(file.getAbsolutePath());
            System.out.printf("Quantidade de ciclos com uso de bolhas: %d %n", ConflictHandler.clockCycles1(instructions));
        }catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("Respostas:");
        System.out.println("Quantidade de ciclos com uso de bolhas: 19");
        System.out.println("Quantidade de ciclos com uso de adiantamento de dados: 14");
    }

    private static void test2() {
        String fileDirectory = "/home/augusto-henrique/Documents/Estudos/BSI/2025_03/ARQUITETURA DE COMPUTADORES/teste1";
        String fileName = "TESTE-01.txt";
        File file = new File(fileDirectory,fileName);
        try {
            List<Instruction> instructions = FileHandler.read(file.getAbsolutePath());
            System.out.println(instructions.get(2));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void test3(){
        String fileDirectory = "/home/augusto-henrique/Documents/Estudos/BSI/2025_03/ARQUITETURA DE COMPUTADORES/teste1";
        String fileName = "TESTE-01.txt";
        File file = new File(fileDirectory,fileName);
        try {
            List<Instruction> instructions = FileHandler.read(file.getAbsolutePath());
            for(Instruction instruction: instructions) {
                System.out.println(instruction);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
