package net.ddns.spellbank.day05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay5 {
	@Test
    void part1() {
        String[] lines = InputFile.getLines("day05/input1");
        assertEquals(238, Day5NiceList.part1(lines));
    }

    @Test
    void part2() {
        String[] lines = InputFile.getLines("day05/input1");
        assertEquals(69, Day5NiceList.part2(lines));
    }
    
    @Test
    void isNice1() {
        assertTrue(Day5NiceList.isNice("ugknbfddgicrmopn"));
    }

    @Test
    void isNice2() {
    	assertTrue(Day5NiceList.isNice("aaa"));
    }
    
    @Test
    void isNice3() {
        assertFalse(Day5NiceList.isNice("jchzalrnumimnmhp"));
    }

    @Test
    void isNice4() {
    	assertFalse(Day5NiceList.isNice("haegwjzuvuyypxyu"));
    }
    
    @Test
    void isNice5() {
    	assertFalse(Day5NiceList.isNice("dvszwmarrgswjxmb"));
    }
    
    @Test
    void isNewNice1() {
        assertTrue(Day5NiceList.isNewNice("qjhvhtzxzqqjkmpb"));
    }

    @Test
    void isNewNice2() {
    	assertTrue(Day5NiceList.isNewNice("xxyxx"));
    }
    
    @Test
    void isNewNice3() {
        assertFalse(Day5NiceList.isNewNice("uurcxstgmygtbstg"));
    }

    @Test
    void isNewNice4() {
    	assertFalse(Day5NiceList.isNewNice("ieodomkazucvgmuy"));
    }

}
