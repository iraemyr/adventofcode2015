package net.ddns.spellbank.day02;

//import java.util.Arrays;

import net.ddns.spellbank.utils.InputFile;

public class Day2Wrapping {

    public static void main(String[] args) {
        String file = "day02/input1";
        String[] lines = InputFile.getLines(file);
        long start = System.nanoTime();
        int p1 = part1(lines);
        long stop = System.nanoTime();
        double ms = (stop - start) / 1000000.0;
        System.out.println("Part1: " + p1); // 1586300
        System.out.println("Completed in " + ms + "ms");
        start = System.nanoTime();
        int p2 = part2(lines);
        stop = System.nanoTime();
        ms = (stop - start) / 1000000.0;
        System.out.println("Part2: " + p2); // 3737498
        System.out.println("Completed in " + ms + "ms");
    }

    public static int part1(String[] lines) {
        int paper = 0;
        for (String str : lines) {
            String[] dims = str.split("x");
            int[] lwh = new int[3];
            for (int i = 0; i < dims.length; i++)
                lwh[i] = Integer.parseInt(dims[i]);
            // Arrays.sort(lwh); // ~ 7.136 ms
            tinySort(lwh); // ~ 5.9893 ms
            paper += lwh[0] * lwh[1];
            paper += 2 * lwh[0] * lwh[1];
            paper += 2 * lwh[1] * lwh[2];
            paper += 2 * lwh[0] * lwh[2];
        }
        return paper;
    }

    public static int part2(String[] lines) {
        int ribbon = 0;
        for (String str : lines) {
            String[] dims = str.split("x");
            int[] lwh = new int[3];
            for (int i = 0; i < dims.length; i++)
                lwh[i] = Integer.parseInt(dims[i]);
            // Arrays.sort(lwh); // ~ 1.6911 ms
            tinySort(lwh); // ~ 1.5011 ms
            ribbon += 2 * lwh[0] + 2 * lwh[1];
            ribbon += lwh[0] * lwh[1] * lwh[2];
        }
        return ribbon;
    }

    private static void tinySort(int[] lwh) {
        if (lwh.length != 3) {
            // Would be more appropriate to throw an exception in production code
            System.out.println("tinySort only suitable for arrays of length 3");
            return;
        }
        int tmp = 0;
        if (lwh[0] > lwh[1]) {
            tmp = lwh[0];
            lwh[0] = lwh[1];
            lwh[1] = tmp;
        }
        if (lwh[1] > lwh[2]) {
            tmp = lwh[1];
            lwh[1] = lwh[2];
            lwh[2] = tmp;
        }
        if (lwh[0] > lwh[1]) {
            tmp = lwh[0];
            lwh[0] = lwh[1];
            lwh[1] = tmp;
        }

    }

}
