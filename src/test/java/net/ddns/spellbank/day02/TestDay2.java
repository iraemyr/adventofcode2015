package net.ddns.spellbank.day02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay2 {
    @Test
    void part1() {
        String[] lines = InputFile.getLines("day02/input1");
        assertEquals(1586300, Day2Wrapping.part1(lines));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day02/input1");
        assertEquals(3737498, Day2Wrapping.part2(lines));
    }

    @Test
    void samplePart1() {
        String[] lines = InputFile.getLines("day02/test");
        assertEquals(58, Day2Wrapping.part1(lines));
    }

    @Test
    void samplePart2() {
        String[] lines = InputFile.getLines("day02/test");
        assertEquals(34, Day2Wrapping.part2(lines));
    }
}
