import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConflictHandler {
    public static ArrayList<String> getRegisters(String instruction) throws NullPointerException{
        final String regex =  """
            \\$(?<register>
              zero|at|v[01]|a[0-3]|t[0-9]|s[0-7]|
              k[01]|gp|sp|fp|ra|pc|hi|lo
            )\\b
            """;
        if(instruction == null  || instruction.isEmpty()) throw new NullPointerException("The instruction cannot be null!");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(instruction);
        ArrayList<String> registers = new ArrayList<>();
        while (matcher.find()) {
            registers.add(matcher.group());
        }
        if(registers.isEmpty()) {
            throw new NullPointerException("This instruction does not have any register!");
        }
        return registers;
    }
}
