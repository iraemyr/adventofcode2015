package net.ddns.spellbank.day24;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay24 {
	private static int sum;
	private static Integer[] sorted;
	
	@BeforeAll
	static void init() {
		String file = "day24/input1";
		String[] lines = InputFile.getLines(file);
		List<Integer> packages = new ArrayList<>();
		sum = Day24PackSleigh.parseAndGetSum(packages, lines);
		sorted = Day24PackSleigh.getSortedArray(packages);
	}
	
	@Test
	void part1() {
		assertEquals("10723906903", Long.toUnsignedString(Day24PackSleigh.part1(sum, sorted)));
	}
	
	@Test
	void part2() {
		assertEquals("74850409", Long.toUnsignedString(Day24PackSleigh.part2(sum, sorted)));
	}

}
