package net.ddns.spellbank.day10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay10 {
    @Test
    void part1() {
        String[] lines = InputFile.getLines("day10/input1");
        assertEquals(252594, Day10LookAndSay.part1(lines[0]).length());
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day10/input1");
        String input = Day10LookAndSay.part1(lines[0]);
        assertEquals(3579328, Day10LookAndSay.part2(input).length());
    }
}
