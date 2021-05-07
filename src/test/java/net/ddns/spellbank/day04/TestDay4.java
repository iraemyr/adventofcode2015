package net.ddns.spellbank.day04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay4 {
	@Test
    void part1() {
        String[] lines = InputFile.getLines("day04/input1");
        assertEquals(117946, Day4MD5.part1(lines[0]));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day04/input1");
        assertEquals(3938038, Day4MD5.part2(lines[0]));
    }
}
