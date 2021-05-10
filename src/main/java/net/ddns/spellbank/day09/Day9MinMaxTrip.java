package net.ddns.spellbank.day09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.ddns.spellbank.utils.InputFile;

public class Day9MinMaxTrip {
    private static int MIN_DIST = Integer.MAX_VALUE;
    private static int MAX_DIST = 0;

    public static void main(String[] args) {
        String file = "day09/input1";
        String[] lines = InputFile.getLines(file);

        Map<String, City> map = makeMap(lines);
        Set<String> visited = new HashSet<>();
        System.out.println(part1(map, visited)); // 117
        visited.clear();
        System.out.println(part2(map, visited)); // 909
    }

    public static int part1(Map<String, City> map, Set<String> visited) {
        MIN_DIST = Integer.MAX_VALUE;
        for (String s : map.keySet())
            calcMin(map, 0, visited, s);
        return MIN_DIST;
    }

    public static int part2(Map<String, City> map, Set<String> visited) {
        MAX_DIST = 0;
        for (String s : map.keySet())
            calcMax(map, 0, visited, s);
        return MAX_DIST;
    }

    public static Map<String, City> makeMap(String[] lines) {
        Map<String, City> map = new HashMap<>();

        for (String str : lines) {
            String[] fields = str.split(" ");
            String src = fields[0];
            String dest = fields[2];
            int dist = Integer.parseInt(fields[4]);
            // System.out.println(src + " " + dest + " " + dist);
            City source = map.getOrDefault(src, new City(src));
            City destination = map.getOrDefault(dest, new City(dest));
            source.addDestination(dest, dist);
            map.put(src, source);
            destination.addDestination(src, dist);
            map.put(dest, destination);
        }

        return map;
    }

    private static void calcMin(Map<String, City> map, int dist, Set<String> visited, String city) {
        if (dist > MIN_DIST)
            return;
        visited.add(city);
        if (visited.size() == map.size()) {
            MIN_DIST = Math.min(dist, MIN_DIST);
            visited.remove(city);
            return;
        }
        City c = map.get(city);
        for (CityLink link : c.destinations) {
            if (!visited.contains(link.destination))
                calcMin(map, dist + link.distance, visited, link.destination);
        }
        visited.remove(city);
    }

    private static void calcMax(Map<String, City> map, int dist, Set<String> visited, String city) {
        visited.add(city);
        if (visited.size() == map.size()) {
            MAX_DIST = Math.max(dist, MAX_DIST);
            visited.remove(city);
            return;
        }
        City c = map.get(city);
        for (CityLink link : c.destinations) {
            if (!visited.contains(link.destination))
                calcMax(map, dist + link.distance, visited, link.destination);
        }
        visited.remove(city);
    }
}
