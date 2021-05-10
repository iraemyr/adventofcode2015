package net.ddns.spellbank.day13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay13 {

    @Test
    void part1() {
        String[] lines = InputFile.getLines("day13/input1");
        var map = Day13Seating.buildPreferences(lines);
        Set<String> people = new HashSet<>(map.keySet());
        assertEquals(618, Day13Seating.part1(map, people));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day13/input1");
        var map = Day13Seating.buildPreferences(lines);
        Set<String> people = new HashSet<>(map.keySet());
        assertEquals(601, Day13Seating.part2(map, people));
    }

}
