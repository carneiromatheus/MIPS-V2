import java.util.ArrayList;

public class Instruction {
    private String $rt; //register stored
    private String $rs1; //register read 1
    private String $rs2; //register read 2
    public Instruction(String instructionType, ArrayList<String> registers) {
        setInstructionType(instructionType, registers);
    }

    public void setInstructionType(String instructionType, ArrayList<String> registers) {
        switch (instructionType) {
            case "add", "addu", "sub", "subu", "and", "or", "nor", "slt", "sltu" :
                $rt = (registers.get(0)); //Setando registrador 1 como write
                $rs1 = (registers.get(1)); //Setando registrador 2 como read
                $rs2 = (registers.get(2)); //Setando registrador 3 como read
                break;
            case "addi", "addiu", "subi", "andi", "ori", "xori", "slti", "sltiu", "lw", "lb", "lbu", "lh", "lhu", "lwl", "lwr":
                $rt = (registers.get(0)); //Setando registrador 1 como write
                $rs1 = (registers.get(1)); //Setando registrador 2 e 3 como read
                break;
            case "sw", "sb", "sh", "swl", "swr":
                $rs1 = registers.get(0);
                $rs2 = registers.get(1);
            case "bgez", "bltz", "blez", "bgtz", "jr":
                $rs1 = registers.get(0);
            case "j":
                $rt = null;
                $rs1 = null;
                $rs2 = null;
                default:
                throw new NullPointerException("Unacknowledged instruction: "+instructionType);
        }

    }
}
