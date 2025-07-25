import java.util.ArrayList;
import java.util.List;

public class ConflictHandler {
    private ConflictHandler(){

    }

    public static void clockCicles(List<Instruction> instructions) { //Retirar o retorno void
        for(int i = 0; i < instructions.size(); i++){
            if(isConflict(instructions.get(i), instructions.get(i+1))) {
                System.out.printf("Conflito da instrução %d com %d %n",i,i+1);
            }
            if(isConflict(instructions.get(i), instructions.get(i+2))) {
                System.out.printf("Conflito da instrução %d com %d %n",i,i+2);
            }
            
        }
        
        //return clockCicles;
    }

    private static boolean isConflict(Instruction I1, Instruction I2){
        if(I1.getWrite() == null)return false;
        else 
            if(I1.getWrite().equals(I2.getRead()[0])|| I1.getWrite().equals(I2.getRead()[1])) return true;
            else return false; 
        
    }
}
