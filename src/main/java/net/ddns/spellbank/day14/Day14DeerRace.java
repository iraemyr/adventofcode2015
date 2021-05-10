package net.ddns.spellbank.day14;

import java.util.ArrayList;
import java.util.List;

import net.ddns.spellbank.utils.InputFile;

public class Day14DeerRace {

    public static void main(String[] args) {
        String file = "day14/input1";
        String[] lines = InputFile.getLines(file);

        List<Deer> deer = parseDeer(lines);
        doRace(deer, 2503);
        System.out.println(part1(deer)); // 2655
        System.out.println(part2(deer)); // 1059
    }

    public static int part1(List<Deer> deer) {
        int max = 0;
        for (Deer d : deer)
            max = Math.max(max, d.distance);
        return max;
    }

    public static int part2(List<Deer> deer) {
        int score = 0;
        for (Deer d : deer)
            score = Math.max(score, d.score);
        return score;
    }

    public static List<Deer> parseDeer(String[] lines) {
        List<Deer> deer = new ArrayList<>();
        for (String str : lines) {
            String[] fields = str.split(" ");
            String name = fields[0];
            int speed = Integer.parseInt(fields[3]);
            int runTime = Integer.parseInt(fields[6]);
            int rest = Integer.parseInt(fields[13]);
            Deer d = new Deer(name, speed, runTime, rest);
            // d.print();
            deer.add(d);
        }
        return deer;
    }

    public static void doRace(List<Deer> deer, int time) {
        for (int i = 0; i < time; i++) {
            long maxd = 0;
            for (Deer d : deer) {
                d.update();
                maxd = Math.max(maxd, d.distance);
            }
            for (Deer d : deer)
                if (d.distance == maxd)
                    d.score();
        }
    }
}
