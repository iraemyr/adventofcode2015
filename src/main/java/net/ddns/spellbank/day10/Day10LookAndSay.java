package net.ddns.spellbank.day10;

import net.ddns.spellbank.utils.InputFile;

public class Day10LookAndSay {

    public static void main(String[] args) {
        String file = "day10/input1";
        String[] lines = InputFile.getLines(file);

        String input = lines[0];
        input = part1(input);
        System.out.println(input.length()); // 252594
        input = part2(input);
        System.out.println(input.length()); // 3579328
    }

    public static String part1(String input) {
        return doCycles(40, input);
    }

    public static String part2(String input) {
        return doCycles(10, input);
    }

    private static String doCycles(int cycles, String start) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cycles; i++) {
            sb.setLength(0);
            int count = 1;
            char prev = start.charAt(0);
            for (int j = 1; j < start.length(); j++) {
                char c = start.charAt(j);
                if (c == prev)
                    count++;
                else {
                    sb.append(count).append(prev);
                    prev = c;
                    count = 1;
                }
            }
            sb.append(count).append(prev);
            start = sb.toString();
            // System.out.println(sb.toString());

        }
        return start;
    }
}
