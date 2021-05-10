package net.ddns.spellbank.day12;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay12 {

    @Test
    void part1() {
        String[] lines = InputFile.getLines("day12/input1");
        assertEquals(111754, Day12JSON.part1(lines[0]));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day12/input1");
        assertEquals(65402, Day12JSON.part2(lines[0]));
    }

    @Test
    void part2Array() {
        String[] lines = InputFile.getLines("day12/Array");
        assertEquals(4, Day12JSON.part2(lines[0]));
    }

    @Test
    void part2RedObject() {
        String[] lines = InputFile.getLines("day12/Object");
        assertEquals(0, Day12JSON.part2(lines[0]));
    }

    @Test
    void part2BlueObject() {
        String[] lines = InputFile.getLines("day12/BlueObject");
        assertEquals(15, Day12JSON.part2(lines[0]));
    }

    @Test
    void part2empty() {
        String[] lines = InputFile.getLines("day12/test");
        assertEquals(0, Day12JSON.part2(lines[0]));
    }

}
