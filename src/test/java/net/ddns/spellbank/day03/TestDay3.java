package net.ddns.spellbank.day03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay3 {
    @Test
    void part1() {
        String[] lines = InputFile.getLines("day03/input1");
        assertEquals(2081, Day3PresentDelivery.part1(lines));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day03/input1");
        assertEquals(2341, Day3PresentDelivery.part2(lines));
    }

    @Test
    void samplePart1() {
        String[] lines = InputFile.getLines("day03/test");
        assertEquals(4, Day3PresentDelivery.part1(lines));
    }

    @Test
    void samplePart2() {
        String[] lines = InputFile.getLines("day03/test");
        assertEquals(3, Day3PresentDelivery.part2(lines));
    }
}
