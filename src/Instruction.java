import java.util.ArrayList;

public class Instruction {
    private String opcode;
    private String $rt; 
    private String $rs[];
    public Instruction(String[] line) {
        this.$rs = new String[2];
        this.opcode = line[0]; 
        setInstructionType(line);
    }

    private void setInstructionType(String[] line) {
        switch (opcode) {
            case "add", "addu", "sub", "subu", "and", "or", "nor", "slt", "sltu" : //Case: write, read, read 
                $rt = line[1]; 
                $rs[0] = line[2]; 
                $rs[1]= line[3]; 
                break;
            case "addi", "addiu", "subi", "andi", "ori", "xori", "slti", "sltiu", "lb", "lbu", "lh", "lhu", "lwl", "lwr": //Case: write, read
                $rt = line[1]; 
                $rs[0] = line[2]; 
                $rs[1] = null;
                break;
            case "sw", "sb", "sh", "swl", "swr": //Case: read, read
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = line[3];
                break;
            case "lw":
                $rt = line[1];
                $rs[0] = line[3];
                $rs[1] = null;
                break;    
            case "bgez", "bltz", "blez", "bgtz", "jr", "bnez": //Case: read
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = null;
                break;
            case "j": //Case n/a
                $rt = null;
                $rs[0] = null;
                $rs[1] = null;
                break;
            case "beq": //Case read, read no imeddiate
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = line[2];
                break;
            default:
                throw new NullPointerException("UNACKNOWLEGED INSTRUCTION: "+opcode);
        }
    }
    
    public String[] getRead(){ 
        return $rs;
    }

    public String getWrite(){
        if($rt != null) return $rt;
        else return null; 
    }

    public String getOpcode(){
        return opcode;
    }
    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Instruction " + opcode + " ").append("Register write: ").append($rt).append(" Register read: ").append($rs[0]).append(", " + $rs[1]);
        return sb.toString();
    }

}

