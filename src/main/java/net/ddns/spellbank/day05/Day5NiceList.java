package net.ddns.spellbank.day05;

import java.util.HashMap;
import java.util.Map;

import net.ddns.spellbank.utils.InputFile;

public class Day5NiceList {
    private static Map<String, Integer> SUBSTRS = new HashMap<>();

    public static void main(String[] args) {
        String file = "day05/input1";
        String[] lines = InputFile.getLines(file);

        System.out.println(part1(lines)); // 238
        System.out.println(part2(lines)); // 69
    }

    public static int part1(String[] lines) {
        int nice = 0;
        for (String s : lines) {
            if (isNice(s))
                nice++;
        }
        return nice;
    }

    public static int part2(String[] lines) {
        int nice = 0;
        for (String s : lines) {
            if (isNewNice(s))
                nice++;
        }
        return nice;
    }

    public static boolean isNice(String s) {
        int vowels = 0;
        boolean repeat = false;
        char prev = '0';
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowels++;
            if (c == prev)
                repeat = true;
            switch (c) {
            case 'b':
                if (prev == 'a')
                    return false;
                break;
            case 'd':
                if (prev == 'c')
                    return false;
                break;
            case 'q':
                if (prev == 'p')
                    return false;
                break;
            case 'y':
                if (prev == 'x')
                    return false;
                break;
            default:
            }
            prev = c;
        }
        return (vowels > 2 && repeat);
    }

    public static boolean isNewNice(String s) {
        SUBSTRS.clear();
        char pprev = '0';
        char prev = '1';
        boolean repeatGap = false; // repeating char with one char between
        boolean repeatPair = false;
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c == pprev)
                repeatGap = true;
            if (!repeatPair) {
                String key = "" + prev + c;
                int index = SUBSTRS.getOrDefault(key, 100);
                if (index == 100)
                    SUBSTRS.put(key, i);
                else {
                    if (i - index > 1)
                        repeatPair = true;
                }
            }
            pprev = prev;
            prev = c;
            i++;
            if (repeatGap && repeatPair)
                return true;
        }
        return false;
    }
}
