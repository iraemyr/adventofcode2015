package net.ddns.spellbank.day18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay18 {
	
	@Test
	void part1() {
		String file = "day18/input1";
		String[] lines = InputFile.getLines(file);
		char[][] map = Day18LightsMap.parseMap(lines);
		assertEquals(814, Day18LightsMap.part1(map, 100));
	}
	
	@Test
	void part2() {
		String file = "day18/input1";
		String[] lines = InputFile.getLines(file);
		char[][] map = Day18LightsMap.parseMap(lines);
		assertEquals(924, Day18LightsMap.part2(map, 100));
	}
	
	@Test
	void simplePart1() {
		String file = "day18/test";
		String[] lines = InputFile.getLines(file);
		char[][] map = Day18LightsMap.parseMap(lines);
		assertEquals(4, Day18LightsMap.part1(map, 4));
	}
	
	@Test
	void simplePart2() {
		String file = "day18/test";
		String[] lines = InputFile.getLines(file);
		char[][] map = Day18LightsMap.parseMap(lines);
		assertEquals(17, Day18LightsMap.part2(map, 5));
	}

}
