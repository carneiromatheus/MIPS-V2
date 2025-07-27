import java.util.ArrayList;
import java.util.List;

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

    public static int clockCycles1(List<Instruction> instructions) { //Retirar o retorno void
            int bubbles1 = instructions.size() + 4;;
        for(int i = 0; i < instructions.size()-1; i++){
            if(i > instructions.size() - 3) {
                Instruction I1 = instructions.get(i);
                Instruction I2 = instructions.get(i+1);
                if(isConflict(I1, I2)) {
                System.out.printf("Conflito da instrução %s com %s %n",I1.getOpcode(),I2.getOpcode());
                bubbles1 = bubbles1 + 2;
                }   
            }
            else{
                Instruction I1 = instructions.get(i);
                Instruction I2 = instructions.get(i+1);
                Instruction I3 = instructions.get(i+2);    
                if(isConflict(I1, I2)) {
                System.out.printf("Conflito da instrução %s com %s %n",I1.getOpcode(),I2.getOpcode());
                bubbles1 = bubbles1 + 2;
                }
                if(isConflict(I1, I3)) {
                    System.out.printf("Conflito da instrução %s com %s %n",I1.getOpcode(),I3.getOpcode());
                    if(!isConflict(I1, I2)) {
                        bubbles1++;
                    }
                }    
            }
        }
        return bubbles1;
    }

        private static boolean isConflict(Instruction I1, Instruction I2){
        if(I1.getWrite() == null)return false;
        else 
            if(I1.getWrite().equals(I2.getRead()[0])|| I1.getWrite().equals(I2.getRead()[1])) return true;
            else return false; 
        
    }
}
