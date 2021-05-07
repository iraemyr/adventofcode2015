package net.ddns.spellbank.day07;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay7 {
	@Test
    void part1() {
        String[] lines = InputFile.getLines("day07/input1");
        Map<String, InputOutput> map = Day7LogicalCircuits.buildMap(lines);
        assertEquals(16076, Day7LogicalCircuits.part1(map));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day07/input1");
        Map<String, InputOutput> map = Day7LogicalCircuits.buildMap(lines);
        assertEquals(2797, Day7LogicalCircuits.part2(map, (char) 16076));
    }
}
