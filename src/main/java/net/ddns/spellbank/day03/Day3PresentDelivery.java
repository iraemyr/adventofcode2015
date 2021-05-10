package net.ddns.spellbank.day03;

import java.util.HashMap;
import java.util.Map;

import net.ddns.spellbank.utils.InputFile;
import net.ddns.spellbank.utils.Tuple;

public class Day3PresentDelivery {

    public static void main(String[] args) {
        String file = "day03/input1";
        String[] lines = InputFile.getLines(file);

        System.out.println(part1(lines)); // 2081
        System.out.println(part2(lines)); // 2341
    }

    public static int part1(String[] lines) {
        int x = 0, y = 0;
        Map<String, Integer> world = new HashMap<>();
        world.put(new Tuple(x, y).toString(), 1);
        for (String str : lines) {
            for (char c : str.toCharArray()) {
                switch (c) {
                case '^':
                    y++;
                    break;
                case '>':
                    x++;
                    break;
                case 'v':
                    y--;
                    break;
                case '<':
                    x--;
                    break;
                default:
                    System.out.println("Error in input");
                }
                String t = new Tuple(x, y).toString();
                int quantity = world.getOrDefault(t, 0);
                world.put(t, ++quantity);
            }
        }
        return world.keySet().size();
    }

    public static int part2(String[] lines) {
        int[][] p = new int[2][2];
        boolean santa = true;
        Map<String, Integer> world = new HashMap<>();
        world.put(new Tuple(0, 0).toString(), 2);
        for (String str : lines) {
            for (char c : str.toCharArray()) {
                int[] pos = santa ? p[0] : p[1];
                switch (c) {
                case '^':
                    pos[1]++;
                    break;
                case '>':
                    pos[0]++;
                    break;
                case 'v':
                    pos[1]--;
                    break;
                case '<':
                    pos[0]--;
                    break;
                default:
                    System.out.println("Error in input");
                }
                String t = new Tuple(pos[0], pos[1]).toString();
                int quantity = world.getOrDefault(t, 0);
                world.put(t, ++quantity);
                santa = !santa;
            }
        }
        return world.keySet().size();
    }

}
