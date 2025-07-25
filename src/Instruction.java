import java.util.ArrayList;

public class Instruction {
    private String $rt; //register stored
    private String $rs1; //register read 1
    private String $rs2; //register read 2
    public Instruction(String[] line) {
        setInstructionType(line);
    }

    private void setInstructionType(String[] line) {
        switch (line[0]) {
            case "add", "addu", "sub", "subu", "and", "or", "nor", "slt", "sltu" :
                $rt = (line[1]); //Setando registrador 1 como write
                $rs1 = (line[2]); //Setando registrador 2 como read
                $rs2 = (line[3]); //Setando registrador 3 como read
                break;
            case "addi", "addiu", "subi", "andi", "ori", "xori", "slti", "sltiu", "lw", "lb", "lbu", "lh", "lhu", "lwl", "lwr":
                $rt = (line[1]); //Setando registrador 1 como write
                $rs1 = (line[2]); //Setando registrador 2 e 3 como read
                break;
            case "sw", "sb", "sh", "swl", "swr":
                $rs1 = line[1];
                $rs2 = line[3];
                break;
            case "bgez", "bltz", "blez", "bgtz", "jr":
                $rs1 = line[1];
                break;
            case "j":
                $rt = null;
                $rs1 = null;
                $rs2 = null;
                break;
                default:
                throw new NullPointerException("UNACKNOWLEGED INSTRUCTION: "+line[0]);
        }
    }
    private boolean isRegister(String register) {
        if(register == null) return false;
        else return true;
    }


    public String[] getRead(){ 
        if(isRegister($rs1)&& isRegister($rs2)) {
            String[] readRegisters = {$rs1, $rs2};
            return readRegisters;
        }  
        else if(isRegister($rs1)) {
            String[] readRegisters = {$rs1};
            return readRegisters;
        }
        else if (isRegister($rs2)){
            String[] readRegisters = {$rs2};
            return readRegisters;
        }
        else{
            throw new NullPointerException("UNEXPECTED_REGISTER_NOT_FOUND");
        }
    }
    public String getWrite(){
        if($rt != null) return $rt;
        else return null; 
    }
}
