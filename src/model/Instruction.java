package model;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;

public class Instruction {
    private String opcode;
    private String $rt; 
    private String $rs[];
    private boolean accesMemory;
    private boolean conditionalDeviation;
    public Instruction(String[] line) {
        this.$rs = new String[2];
        this.opcode = line[0];
        this.accesMemory = false;
        this.conditionalDeviation = false; 
        setInstructionType(line);
    }
    public Instruction() {
        this.opcode = "NOP";
        this.$rs = new String[2];
        this.$rt = null;
        this.accesMemory = false;
        this.conditionalDeviation = false; 
    }

    private void setInstructionType(String[] line) {
        switch (opcode) {
            case "add", "addu", "sub", "subu", "and", "or", "nor", "slt", "sltu","xor" : //Case: I $rt, $rs, $rs
                $rt = line[1]; 
                $rs[0] = line[2]; 
                $rs[1]= line[3]; 
                break;
            case "addi", "addiu", "subi", "andi", "ori", "xori", "slti", "sltiu", "sll", "slr", "lui": //Case: I $rt, $rs, immediate
                $rt = line[1]; 
                $rs[0] = line[2]; 
                $rs[1] = null;
                break;
            case "sw", "sb", "sh", "swl", "swr": //I $rs, immediate($rs)
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = line[3];
                break;
            case "lw", "lh", "lhu", "lb", "lbu", "lwl", "lwr": //I $rt, immediate($rs)
                $rt = line[1];
                $rs[0] = line[3];
                $rs[1] = null;
                accesMemory = true;
                break;    
            case "bgez", "bltz", "blez", "bgtz", "bnez","beqz": //I $rs, immediate
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = null;
                conditionalDeviation = true;
                break;
            case "j": //I, immediate
                $rt = null;
                $rs[0] = null;
                $rs[1] = null;
                break;
            case "jr": //I, $rs
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = null;
                break;
            case "beq", "bne", "blt", "bge": //I $rs, $rs
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = line[2];
                conditionalDeviation = true;
                break;
            default:
                throw new NullPointerException("UNACKNOWLEGED INSTRUCTION: "+opcode);
        }
    }
    public boolean isConditionalDeviation() {
        return conditionalDeviation;
    }
    public boolean isAccesMemory() {
        return accesMemory;
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
    public boolean isNOP(){
        if(opcode == "NOP") return true;
        else return false;
    }

    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(opcode + " ").append("rw: ").append($rt).append(" rr: ").append($rs[0]).append(", " + $rs[1]);
        return sb.toString();
    }

}

