package net.ddns.spellbank.day24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ddns.spellbank.utils.InputFile;

public class Day24PackSleigh {
    private static int min_num = Integer.MAX_VALUE;
    private static long quantum_min = 0;

    public static void main(String[] args) {
        String file = "day24/input1";
        String[] lines = InputFile.getLines(file);

        int sum = 0;
        List<Integer> packages = new ArrayList<>();
        sum = parseAndGetSum(packages, lines);
        var sorted = getSortedArray(packages);
        Arrays.sort(sorted, (a, b) -> b - a);
        System.out.println(Long.toUnsignedString(part1(sum, sorted))); // 10723906903
        System.out.println(Long.toUnsignedString(part2(sum, sorted))); // 74850409
    }

    public static long part1(int sum, Integer[] sorted) {
        int target = sum / 3;
        min_num = Integer.MAX_VALUE;
        quantum_min = 0;
        Set<Integer> used = new HashSet<>();
        pack(sorted, 0, target, 0, used);
        return quantum_min;
    }

    public static long part2(int sum, Integer[] sorted) {
        int target = sum / 4;
        min_num = Integer.MAX_VALUE;
        quantum_min = 0;
        Set<Integer> used = new HashSet<>();
        pack(sorted, 0, target, 0, used);
        return quantum_min;
    }

    private static void pack(Integer[] sorted, int index, int target, int sum, Set<Integer> used) {
        if (used.size() > min_num)
            return;
        for (int i = index; i < sorted.length; i++) {
            int num = sorted[i];
            if (!used.contains(num) && sum + num <= target) {
                used.add(num);
                if (sum + num == target) {
                    // if (canPack(sorted, target, 0, used)) score(used);
                    score(used);
                } else {
                    pack(sorted, i + 1, target, sum + num, used);
                }
                used.remove(num);
            }
        }
    }

    private static void score(Set<Integer> bundle) {
        if (bundle.size() <= min_num) {
            // printSet(bundle);
            long quantum = 1;
            for (int i : bundle)
                quantum *= i;
            if (quantum_min == 0 || bundle.size() < min_num) {
                quantum_min = quantum;
                min_num = bundle.size();
                // System.out.println("First");
                // System.out.println(min_num + " : " + quantum_min.toString());
                // System.out.println(min_num + " : " + Long.toUnsignedString(quantum_min));
            } else {
                if (Long.compareUnsigned(quantum, quantum_min) < 0)
                    quantum_min = quantum;
            }
        }
    }

    @SuppressWarnings("unused")
    private static void printSet(Set<Integer> s) {
        for (int i : s)
            System.out.print(i + " ");
        System.out.println();
    }

    public static int parseAndGetSum(List<Integer> packages, String[] lines) {
        int sum = 0;
        for (String str : lines) {
            int n = Integer.parseInt(str);
            sum += n;
            packages.add(n);
        }
        return sum;
    }

    public static Integer[] getSortedArray(List<Integer> packages) {
        var sorted = packages.toArray(new Integer[0]);
        Arrays.sort(sorted, (a, b) -> b - a);
        return sorted;
    }

}
