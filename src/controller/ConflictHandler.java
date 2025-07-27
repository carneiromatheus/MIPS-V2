package controller;
import java.util.List;

import model.Instruction;

public class ConflictHandler {

    private ConflictHandler() {
    }

    public static int getCycles(List<Instruction> instructions){
        return readInstructions(instructions).size() + 4;
    }

    public static List<Instruction> readInstructions(List<Instruction> instructions) {
        for(int i = 0; i < instructions.size(); i++){
            if(!instructions.get(i).isNOP()) {
                if(instructions.get(i).isConditionalDeviation()) {
                    instructions.add(i+1, new Instruction());
                    instructions.add(i+2, new Instruction());
                    instructions.add(i+3, new Instruction());
                }
                else{
                    if(i <= instructions.size() - 2){
                        if(isConflict(instructions.get(i), instructions.get(i+1))) {
                        instructions.add(i+1, new Instruction());
                        }
                    }
                }
            }   
        }
        return instructions;
    }

    private static boolean isConflict(Instruction I1, Instruction I2) {
        if(I1.getWrite() == null) return false;
        else {
            if(!I1.isAccesMemory()) return false;
            else {
                if(I1.getWrite().equals(I2.getRead()[0]) || I1.getWrite().equals(I2.getRead()[1])) return true;
                else return false;
            }
        }
    }
    public static void printInstructions(List<Instruction> instructions) {
        for(int i = 0; i < instructions.size();i++) {
            System.out.printf("I%d: %s %n", i,instructions.get(i));
        }
    }
}
