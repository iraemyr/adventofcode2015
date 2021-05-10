package net.ddns.spellbank.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.ddns.spellbank.utils.InputFile;

public class Day17ContainerCombinations {
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String file = "day17/input1";
        String[] lines = InputFile.getLines(file);

        Integer[] b = parseContainers(lines);

        System.out.println(part1(0, b, 0, 0)); // 654
        // System.out.println(MIN); // 4
        System.out.println(part2(0, b, 0, 0, MIN)); // 57
    }

    public static int part1(int sum, Integer[] b, int index, int num) {
        int result = 0;
        if (sum == 0)
            MIN = Integer.MAX_VALUE;
        for (int i = index; i < b.length; i++) {
            int s = sum + b[i];
            if (s > 150)
                break;
            if (s == 150) {
                result++;
                MIN = Math.min(MIN, num + 1);
            } else
                result += part1(s, b, i + 1, num + 1);
        }
        return result;
    }

    public static int part2(int sum, Integer[] b, int index, int num, int max) {
        int result = 0;
        if (sum == 0)
            MIN = Integer.MAX_VALUE;
        for (int i = index; i < b.length; i++) {
            int s = sum + b[i];
            if (s > 150)
                break;
            if (s == 150) {
                result++;
                MIN = Math.min(MIN, num + 1);
            } else if (num + 1 < max)
                result += part2(s, b, i + 1, num + 1, max);
        }
        return result;
    }

    public static Integer[] parseContainers(String[] lines) {
        List<Integer> buckets = new ArrayList<>();
        for (String str : lines) {
            int c = Integer.parseInt(str);
            buckets.add(c);
        }
        Collections.sort(buckets);
        return buckets.toArray(new Integer[0]);
    }
}
