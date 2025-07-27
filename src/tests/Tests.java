package tests;

import model.Instruction;
import java.io.File;
import java.io.IOException;
import java.util.List;

import controller.ConflictHandler;
import controller.FileHandler;

public class Tests {
    public static void main(String[] args) {
        printInstructions();
    }
    private static void isConditionalDeviation(){
        String filePath = "/home/augusto-henrique/Documents/Estudos/BSI/2025_03/ARQUITETURA DE COMPUTADORES/testes/ConditionalDeviation";
        String fileName = "TESTE-00.txt";

        File file = new File(filePath, fileName);
        
        try{
            List<Instruction> instructions = FileHandler.read(file.getAbsolutePath()); 
            for(Instruction instruction: instructions){
                System.out.println(instruction.isConditionalDeviation());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void printInstructions() {
    String filePath = "/home/augusto-henrique/Documents/Estudos/BSI/2025_03/ARQUITETURA DE COMPUTADORES/testes/printInstructions";
        String fileName = "TESTE-03.txt";

        File file = new File(filePath, fileName);
        
        try{
            List<Instruction> instructions = FileHandler.read(file.getAbsolutePath());
             System.out.println("Instruções antes do conflictHandler");
            ConflictHandler.printInstructions(instructions);

            System.out.println("Instruções após do conflictHandler");
            ConflictHandler.printInstructions(ConflictHandler.readInstructions(instructions));
                 
            System.out.println("Resultado esperado: 8 ciclos");
            System.out.printf("Resultado atingido: %d ciclos%n", instructions.size() + 4);

        }catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
}
