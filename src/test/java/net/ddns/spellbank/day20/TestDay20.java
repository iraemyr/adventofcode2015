package net.ddns.spellbank.day20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay20 {
	
	@Test
	void part1() {
		String file = "day20/input1";
		String[] lines = InputFile.getLines(file);
		int limit = Integer.parseInt(lines[0]);
		assertEquals(665280, Day20InfiniteElves.part1(limit));
	}

	@Test
	void part2() {
		String file = "day20/input1";
		String[] lines = InputFile.getLines(file);
		int limit = Integer.parseInt(lines[0]);
		assertEquals(705600, Day20InfiniteElves.part2(limit));
	}
}
