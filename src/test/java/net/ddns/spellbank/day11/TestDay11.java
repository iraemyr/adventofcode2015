package net.ddns.spellbank.day11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay11 {

    @Test
    void part1() {
        String[] lines = InputFile.getLines("day11/input1");
        assertEquals("hxbxxyzz", Day11Passwords.part1(lines[0]));
    }

    @Test
    void part2() {
        assertEquals("hxcaabcc", Day11Passwords.part1("hxbxxyzz"));
    }
}
