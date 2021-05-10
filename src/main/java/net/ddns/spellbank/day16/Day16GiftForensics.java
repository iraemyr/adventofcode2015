package net.ddns.spellbank.day16;

import java.util.ArrayList;
import java.util.List;

import net.ddns.spellbank.utils.InputFile;

public class Day16GiftForensics {

    public static void main(String[] args) {
        String file = "day16/input1";
        String[] lines = InputFile.getLines(file);

        List<Aunt> aunts = parseAunts(lines);

        System.out.println(part1(aunts)); // 373
        System.out.println(part2(aunts)); // 260
    }

    public static int part1(List<Aunt> aunts) {
        for (Aunt a : aunts) {
            // children: 3
            Integer v = a.getProperty("children");
            if (v != null && v != 3)
                continue;
            // cats: 7
            v = a.getProperty("cats");
            if (v != null && v != 7)
                continue;
            // samoyeds: 2
            v = a.getProperty("samoyeds");
            if (v != null && v != 2)
                continue;
            // pomeranians: 3
            v = a.getProperty("pomeranians");
            if (v != null && v != 3)
                continue;
            // akitas: 0
            v = a.getProperty("akitas");
            if (v != null && v != 0)
                continue;
            // vizslas: 0
            v = a.getProperty("vizslas");
            if (v != null && v != 0)
                continue;
            // goldfish: 5
            v = a.getProperty("goldfish");
            if (v != null && v != 5)
                continue;
            // trees: 3
            v = a.getProperty("trees");
            if (v != null && v != 3)
                continue;
            // cars: 2
            v = a.getProperty("cars");
            if (v != null && v != 2)
                continue;
            // perfumes: 1
            v = a.getProperty("perfumes");
            if (v != null && v != 1)
                continue;
            return a.id;
        }
        return -1;
    }

    public static int part2(List<Aunt> aunts) {
        for (Aunt a : aunts) {
            // children: 3
            Integer v = a.getProperty("children");
            if (v != null && v != 3)
                continue;
            // cats: 7
            v = a.getProperty("cats");
            if (v != null && v <= 7)
                continue;
            // samoyeds: 2
            v = a.getProperty("samoyeds");
            if (v != null && v != 2)
                continue;
            // pomeranians: 3
            v = a.getProperty("pomeranians");
            if (v != null && v >= 3)
                continue;
            // akitas: 0
            v = a.getProperty("akitas");
            if (v != null && v != 0)
                continue;
            // vizslas: 0
            v = a.getProperty("vizslas");
            if (v != null && v != 0)
                continue;
            // goldfish: 5
            v = a.getProperty("goldfish");
            if (v != null && v >= 5)
                continue;
            // trees: 3
            v = a.getProperty("trees");
            if (v != null && v <= 3)
                continue;
            // cars: 2
            v = a.getProperty("cars");
            if (v != null && v != 2)
                continue;
            // perfumes: 1
            v = a.getProperty("perfumes");
            if (v != null && v != 1)
                continue;
            return a.id;
        }
        return -1;
    }

    public static List<Aunt> parseAunts(String[] lines) {
        List<Aunt> aunts = new ArrayList<>();
        for (String str : lines) {
            String[] fields = str.split(", ");
            String[] first = fields[0].split(": ");
            String[] f = first[0].split(" ");
            int id = Integer.parseInt(f[1]);
            Aunt a = new Aunt(id);
            String prop = first[1];
            int val = Integer.parseInt(first[2]);
            a.setProperty(prop, val);
            f = fields[1].split(": ");
            prop = f[0];
            val = Integer.parseInt(f[1]);
            a.setProperty(prop, val);
            f = fields[2].split(": ");
            prop = f[0];
            val = Integer.parseInt(f[1]);
            a.setProperty(prop, val);
            aunts.add(a);
            // a.print();
        }
        return aunts;
    }
}
