import java.util.ArrayList;

public class testRegexInstruction {
    public static void main(String[] args) {
        String line = "add $s1, $s2, $s3";
        String instruction = line.split(" ")[0];
        try {
            ArrayList<String> registers = ConflictHandler.getRegisters(line);
            System.out.println(registers);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }

    }
}
