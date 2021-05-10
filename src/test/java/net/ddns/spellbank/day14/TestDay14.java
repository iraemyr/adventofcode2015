package net.ddns.spellbank.day14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay14 {
    private static List<Deer> deer;

    @BeforeAll
    static void prep() {
        String[] lines = InputFile.getLines("day14/input1");
        deer = Day14DeerRace.parseDeer(lines);
        Day14DeerRace.doRace(deer, 2503);
    }

    @Test
    void part1() {
        assertEquals(2655, Day14DeerRace.part1(deer));
    }

    @Test
    void part2() {
        assertEquals(1059, Day14DeerRace.part2(deer));
    }
}
