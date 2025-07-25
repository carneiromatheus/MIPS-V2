import java.util.ArrayList;
import java.util.List;

public class ConflictHandler {

    private ConflictHandler() {
    }

    public static int check(List<ArrayList<String>> instructions) {
        int bubbles = 0;

        for (ArrayList<String> instruction : instructions) {
            String opcode = getOpcode(instruction);
            // Instruction inst = new Instruction(opcode, instruction);
            // Ou utilizar de outra forma
        }

        return bubbles;
    }

    private static String getOpcode(ArrayList<String> instruction) {
        return instruction.get(0);
    }
}
