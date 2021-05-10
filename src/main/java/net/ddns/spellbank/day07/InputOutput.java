package net.ddns.spellbank.day07;

public class InputOutput implements Cloneable {
    Character input1;
    Character input2;
    Op operator;
    String in1;
    String in2;
    Character output;

    public InputOutput(Character input1, Character input2, String in1, String in2, Op op, Character output) {
        this.input1 = input1;
        this.input2 = input2;
        this.in1 = in1;
        this.in2 = in2;
        operator = op;
        this.output = output;
    }

    public Character getOutput() {
        return output;
    }

    public InputOutput clone() {
        return new InputOutput(input1, input2, in1, in2, operator, output);
    }

}
