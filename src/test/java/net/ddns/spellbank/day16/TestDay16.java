package net.ddns.spellbank.day16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay16 {
	private static List<Aunt> aunts;
	
	@BeforeAll
	static void prep() {
		String[] lines = InputFile.getLines("day16/input1");
		aunts = Day16GiftForensics.parseAunts(lines);
	}
	
	@Test
	void part1() {
		assertEquals(373, Day16GiftForensics.part1(aunts));
	}
	
	@Test
	void part2() {
		assertEquals(260, Day16GiftForensics.part2(aunts));
	}

}
