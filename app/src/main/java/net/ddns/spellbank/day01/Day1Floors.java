package net.ddns.spellbank.day01;

import net.ddns.spellbank.utils.InputFile;

public class Day1Floors {
	private static String[] LINES;
	
	public static void main(String[] args) {
		String file = "day01/input1";
		LINES = InputFile.getLines(file);
		
		System.out.println(part1());
		System.out.println(part2());
	}
	
	private static int part1() {
		int floor = 0;
	    for (char c : LINES[0].toCharArray()) {
    		if (c == '(') floor++;
    		else floor--;
    	}
	    return floor;
	}
	
	private static int part2() {
		int floor = 0;
	    int pos = 1;
	    boolean basement = false;
		for (char c : LINES[0].toCharArray()) {
    		if (c == '(') floor++;
    		else floor--;
    		if (!basement) {
    			if (floor == -1) {
    				return pos;
    		    }
                pos++;
    		}
    	}
		return -1;
	}

}
