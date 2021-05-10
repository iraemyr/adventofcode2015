package net.ddns.spellbank.day08;

import net.ddns.spellbank.utils.InputFile;

public class Day8CharEncoding {

    public static void main(String[] args) {
        String file = "day08/input1";
        String[] lines = InputFile.getLines(file);

        System.out.println(part1(lines)); // 1342
        System.out.println(part2(lines)); // 2074
    }

    public static int part1(String[] lines) {
        int code = 0;
        int mem = 0;
        for (String str : lines) {
            code += str.length();
            int m = -2;
            char[] st = str.toCharArray();
            for (int i = 0; i < st.length; i++) {
                if (st[i] == '\\') {
                    if (st[i + 1] == 'x')
                        i += 3;
                    else
                        i++;
                }
                m++;
            }
            mem += m;
        }
        return code - mem;
    }

    public static int part2(String[] lines) {
        int code = 0;
        int mem = 0;
        for (String str : lines) {
            code += str.length();
            int m = 2;
            char[] st = str.toCharArray();
            for (int i = 0; i < st.length; i++) {
                if (st[i] == '"' || st[i] == '\\') {
                    m++;
                }
                m++;
            }
            mem += m;
        }
        return mem - code;
    }
}
