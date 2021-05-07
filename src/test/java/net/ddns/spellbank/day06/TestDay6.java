package net.ddns.spellbank.day06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay6 {
	@Test
    void part1() {
        String[] lines = InputFile.getLines("day06/input1");
        assertEquals(377891, Day6Lights.part1(lines));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day06/input1");
        assertEquals(14110788, Day6Lights.part2(lines));
    }

}
