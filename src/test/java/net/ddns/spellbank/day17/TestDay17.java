package net.ddns.spellbank.day17;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay17 {
	private static Integer[] buckets;
	
	@BeforeAll
	static void parseBuckets() {
		String[] lines = InputFile.getLines("day17/input1");
		buckets = Day17ContainerCombinations.parseContainers(lines);
	}
	
	@Test
	void part1() {
		assertEquals(654, Day17ContainerCombinations.part1(0, buckets, 0, 0));
	}
	
	@Test
	void part2() {
		assertEquals(57, Day17ContainerCombinations.part2(0, buckets, 0, 0, 4));
	}

}
