package net.ddns.spellbank.day08;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay8 {
    @Test
    void part1() {
        String[] lines = InputFile.getLines("day08/input1");
        assertEquals(1342, Day8CharEncoding.part1(lines));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day08/input1");
        assertEquals(2074, Day8CharEncoding.part2(lines));
    }

    @Test
    void samplePart1() {
        String[] lines = InputFile.getLines("day08/test");
        assertEquals(0 + 3 + 7, +1, Day8CharEncoding.part1(lines));
    }

    @Test
    void samplePart2() {
        String[] lines = InputFile.getLines("day08/test");
        assertEquals(4 + 4 + 6 + 5, Day8CharEncoding.part2(lines));
    }

}
