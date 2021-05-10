package net.ddns.spellbank.day23;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay23 {
	private static SimpleComputer comp;
	
	@BeforeAll
	static void init() {
		String file = "day23/input1";
		String[] lines = InputFile.getLines(file);
		var instr = Day23SimpleComputer.parseInput(lines);
		comp = new SimpleComputer(instr);
	}
	
	@Test
	void part1() {
		assertEquals(255, Day23SimpleComputer.part1(comp));
	}
	
	@Test
	void part2() {
		assertEquals(334, Day23SimpleComputer.part2(comp));
	}

}
