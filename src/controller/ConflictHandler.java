package controller;
import java.util.ArrayList;
import java.util.List;

import model.Instruction;

public class ConflictHandler {

    private ConflictHandler() {
    }

    public static int check(List<Instruction> instructions) {
        int bubbles = 0;

        for (Instruction instruction : instructions) {
            String opcode = instruction.getOpcode();

        }

        return bubbles;
    }

    /*public static int clockCycles1(List<Instruction> instructions) { // Retirar o retorno void
        int bubbles1 = instructions.size() + 4;

        return bubbles1;
    }

    public int conflictCycleCounter1(List<Instruction> instructions) {
        int bubbles1 = 0;
        for (int i = 0; i < instructions.size() - 1; i++) {
            if (i > instructions.size() - 3) {
                Instruction I1 = instructions.get(i);
                Instruction I2 = instructions.get(i + 1);
                if (isConflict(I1, I2)) {
                    System.out.printf("Conflito da instrução %s com %s %n", I1.getOpcode(), I2.getOpcode());
                    bubbles1 = bubbles1 + 2;
                }
            } else {
                Instruction I1 = instructions.get(i);
                Instruction I2 = instructions.get(i + 1);
                Instruction I3 = instructions.get(i + 2);
                if (isConflict(I1, I2)) {
                    System.out.printf("Conflito da instrução %s com %s %n", I1.getOpcode(), I2.getOpcode());
                    bubbles1 = bubbles1 + 2;
                }
                if (isConflict(I1, I3)) {
                    System.out.printf("Conflito da instrução %s com %s %n", I1.getOpcode(), I3.getOpcode());
                    if (!isConflict(I1, I2)) {
                        bubbles1++;
                    }
                }
            }
        }
        return bubbles1;
    }*/

    public static List<Instruction> readInstructions(List<Instruction> instructions) {
        for(int i = 0; i < instructions.size(); i++){
            if(!instructions.get(i).isNOP()) {
                if(instructions.get(i).isConditionalDeviation()) {
                    instructions.add(i+1, new Instruction());
                    instructions.add(i+2, new Instruction());
                    instructions.add(i+3, new Instruction());
                }
                else{
                    if(i < instructions.size() - 2){
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
        
        /*if (I1.getWrite() == null) return false;
        else if (I1.getWrite().equals(I2.getRead()[0]) || I1.getWrite().equals(I2.getRead()[1]))
            return true;
        else
            return false;*/
    }
    public static void printInstructions(List<Instruction> instructions) {
        for(int i = 0; i < instructions.size();i++) {
            System.out.printf("I%d: %s %n", i,instructions.get(i));
        }
    }
}
