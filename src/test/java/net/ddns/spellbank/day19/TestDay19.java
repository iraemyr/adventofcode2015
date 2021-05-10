package net.ddns.spellbank.day19;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay19 {

    @Test
    void part1() {
        String file = "day19/input1";
        String[] lines = InputFile.getLines(file);
        List<String[]> input = new ArrayList<>();
        String molecule = Day19MedicineMolecule.parseInput(input, lines);
        assertEquals(535, Day19MedicineMolecule.part1(input, molecule));
    }

    @Test
    void part2() {
        String file = "day19/input1";
        String[] lines = InputFile.getLines(file);
        List<String[]> input = new ArrayList<>();
        String molecule = Day19MedicineMolecule.parseInput(input, lines);
        assertEquals(212, Day19MedicineMolecule.part2(input, molecule));
    }
}
