package net.ddns.spellbank.day09;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay9 {
	
	@Test
	void part1() {
		String[] lines = InputFile.getLines("day09/input1");
		var map = Day9MinMaxTrip.makeMap(lines);
		Set<String> visited = new HashSet<>();
		assertEquals(117, Day9MinMaxTrip.part1(map, visited));
	}
	
	@Test
	void part2() {
		String[] lines = InputFile.getLines("day09/input1");
		var map = Day9MinMaxTrip.makeMap(lines);
		Set<String> visited = new HashSet<>();
		assertEquals(909, Day9MinMaxTrip.part2(map, visited));
	}
	
	@Test
	void samplePart1() {
		String[] lines = InputFile.getLines("day09/test");
		var map = Day9MinMaxTrip.makeMap(lines);
		Set<String> visited = new HashSet<>();
		assertEquals(605, Day9MinMaxTrip.part1(map, visited));
	}
	
	@Test
	void samplePart2() {
		String[] lines = InputFile.getLines("day09/test");
		var map = Day9MinMaxTrip.makeMap(lines);
		Set<String> visited = new HashSet<>();
		assertEquals(982, Day9MinMaxTrip.part2(map, visited));
	}

}
