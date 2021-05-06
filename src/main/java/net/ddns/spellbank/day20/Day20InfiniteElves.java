package net.ddns.spellbank.day20;


import net.ddns.spellbank.utils.InputFile;

public class Day20InfiniteElves {
	private static String[] LINES;

	public static void main(String[] args) {
		String file = "day20/input1";
		LINES = InputFile.getLines(file);
		int limit = Integer.parseInt(LINES[0]);
		
		System.out.println(part1(limit)); // 665280
		System.out.println(part2(limit)); // 705600
	}
	
	private static long part1(int limit) {
		int[] houses = new int[800001];
	    for (int i = 1; i < houses.length; i++) {
	    	int house = i;
	    	int amt = 10 * i;
	    	while (house < houses.length) {
	    		houses[house] += amt;
	    		house += i;
	    	}
	    }
	    for (int i = 1; i < houses.length; i++) {
	    	if (houses[i] > limit) return i;
	    }
		return -1;
	}
	
	private static int part2(int limit) {
		int[] houses = new int[1000001];
	    for (int i = 1; i < houses.length; i++) {
	    	int amt = 11 * i;
	    	for (int j = 1; j <= 50; j++) {
	    		int in = i * j;
	    		if (in < houses.length) houses[in] += amt;
	    	}
	    }
	    
	    for (int i = 1; i < houses.length; i++) {
	    	if (houses[i] > limit) return i;
	    }
	    return -1;
	}
}
