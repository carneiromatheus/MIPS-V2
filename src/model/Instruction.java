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
    }

    private void setInstructionType(String[] line) {
        switch (opcode) {
            case "add", "addu", "sub", "subu", "and", "or", "nor", "slt", "sltu" : //Case: write, read, read 
                $rt = line[1]; 
                $rs[0] = line[2]; 
                $rs[1]= line[3]; 
                break;
            case "addi", "addiu", "subi", "andi", "ori", "xori", "slti", "sltiu": //Case: write, read
                $rt = line[1]; 
                $rs[0] = line[2]; 
                $rs[1] = null;
                break;
            case "sw", "sb", "sh", "swl", "swr": //Case: read, read
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = line[3];
                break;
            case "lw", "lh", "lhu", "lb", "lbu", "lwl", "lwr":
                $rt = line[1];
                $rs[0] = line[3];
                $rs[1] = null;
                accesMemory = true;
                break;    
            case "bgez", "bltz", "blez", "bgtz", "jr", "bnez","beqz": //Case: read
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = null;
                conditionalDeviation = true;
                break;
            case "j": //Case n/a
                $rt = null;
                $rs[0] = null;
                $rs[1] = null;
                break;
            case "beq", "bne", "blt", "bge": //Case read, read no imeddiate
                $rt = null;
                $rs[0] = line[1];
                $rs[1] = line[2];
                conditionalDeviation = true;
                break;
            /*case "NOP":
                $rt = null;
                $rs[0] = null;
                $rs[1] = null;
                break;*/
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
        if(!opcode.equals("NOP")) sb.append(opcode + " ").append("rw: ").append($rt).append(" rr: ").append($rs[0]).append(", " + $rs[1]);
        else sb.append(opcode);
        return sb.toString();
    }

}

