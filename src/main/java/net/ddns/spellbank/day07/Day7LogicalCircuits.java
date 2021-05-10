package net.ddns.spellbank.day07;

import java.util.HashMap;
import java.util.Map;

import net.ddns.spellbank.utils.InputFile;

public class Day7LogicalCircuits {

    public static void main(String[] args) {
        String file = "day07/input1";
        String[] lines = InputFile.getLines(file);

        Map<String, InputOutput> outputs = buildMap(lines);
        Map<String, InputOutput> outputs2 = copyMap(outputs);
        int result = part1(outputs);
        System.out.println(result); // 16076
        System.out.println(part2(outputs2, (char) result)); // 2797
    }

    public static int part1(Map<String, InputOutput> outputs) {
        return resolve("a", outputs);
    }

    public static int part2(Map<String, InputOutput> outputs, char override) {
        InputOutput io = outputs.get("b");
        io.output = override;
        return resolve("a", outputs);
    }

    private static Character resolve(String s, Map<String, InputOutput> outputs) {
        InputOutput io = outputs.get(s);
        Character result = io.getOutput();
        if (result != null)
            return result;
        Character a = io.input1;
        if (a == null)
            a = resolve(io.in1, outputs);
        if (io.operator == Op.NOP) {
            io.output = a;
            return a;
        } else if (io.operator == Op.NOT) {
            result = (char) ~a;
            io.output = result;
            return result;
        } else {
            Character b = io.input2;
            if (b == null)
                b = resolve(io.in2, outputs);
            switch (io.operator) {
            case AND:
                result = (char) (a & b);
                break;
            case OR:
                result = (char) (a | b);
                break;
            case LSHIFT:
                result = (char) (a << b);
                break;
            case RSHIFT:
                result = (char) (a >>> b);
                break;
            default:
            }
        }
        io.output = result;
        return result;
    }

    public static Map<String, InputOutput> buildMap(String[] lines) {
        Map<String, InputOutput> outputs = new HashMap<>();
        for (String str : lines) {
            String[] fields = str.split(" -> ");
            String[] inputs = fields[0].split(" ");
            InputOutput io;

            if (inputs.length == 1) { // Value
                if (Character.isDigit(str.charAt(0))) {
                    char val = (char) Integer.parseInt(fields[0]);
                    io = new InputOutput(null, null, "", "", null, val);
                } else
                    io = new InputOutput(null, null, fields[0], "", Op.NOP, null);
            } else if (inputs.length == 2) { // NOT
                if (Character.isDigit(inputs[1].charAt(0))) {
                    char val = (char) Integer.parseInt(inputs[1]);
                    io = new InputOutput(val, null, "", "", Op.NOT, null);
                } else {
                    io = new InputOutput(null, null, inputs[1], "", Op.NOT, null);
                }
            } else {
                Character a = null;
                Character b = null;
                String a1 = "";
                String b1 = "";
                if (Character.isDigit(inputs[0].charAt(0)))
                    a = (char) Integer.parseInt(inputs[0]);
                else
                    a1 = inputs[0];
                if (Character.isDigit(inputs[2].charAt(0)))
                    b = (char) Integer.parseInt(inputs[2]);
                else
                    b1 = inputs[2];
                if (inputs[1].charAt(0) == 'A') { // AND
                    io = new InputOutput(a, b, a1, b1, Op.AND, null);
                } else if (inputs[1].charAt(0) == 'O') { // OR
                    io = new InputOutput(a, b, a1, b1, Op.OR, null);
                } else if (inputs[1].charAt(0) == 'L') { // LSHIFT
                    io = new InputOutput(a, b, a1, b1, Op.LSHIFT, null);
                } else { // RSHIFT
                    io = new InputOutput(a, b, a1, b1, Op.RSHIFT, null);
                }
            }
            outputs.put(fields[1], io);
        }
        return outputs;
    }

    public static Map<String, InputOutput> copyMap(Map<String, InputOutput> src) {
        Map<String, InputOutput> copy = new HashMap<>();
        for (String key : src.keySet()) {
            InputOutput val = src.get(key);
            InputOutput cp = val.clone();
            copy.put(key, cp);
        }
        return copy;
    }
}
