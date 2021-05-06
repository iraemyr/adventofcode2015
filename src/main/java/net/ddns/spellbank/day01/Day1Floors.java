package net.ddns.spellbank.day01;

import net.ddns.spellbank.utils.InputFile;

public class Day1Floors {
	
	public static void main(String[] args) {
		/*String file = "src/net/ddns/spellbank/day01/input1";
		LINES = InputFile.getLines(file);*/
		String file = "day01/input1";
		String[] lines = InputFile.getLines(file);
		
		
		System.out.println(part1(lines)); // 280
		System.out.println(part2(lines)); // 1797
	}
	
	public static int part1(String[] lines) {
		int floor = 0;
	    for (char c : lines[0].toCharArray()) {
    		if (c == '(') floor++;
    		else floor--;
    	}
	    return floor;
	}
	
	public static int part2(String[] lines) {
		int floor = 0;
	    int pos = 1;
	    boolean basement = false;
		for (char c : lines[0].toCharArray()) {
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
