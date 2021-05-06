package net.ddns.spellbank.day23;


import net.ddns.spellbank.utils.InputFile;

public class Day23SimpleComputer {
	private static String[] LINES;

	public static void main(String[] args) {
		String file = "day23/input1";
		LINES = InputFile.getLines(file);
		String[][] instructions = parseInput();
		
		SimpleComputer comp = new SimpleComputer(instructions);
		
		System.out.println(part1(comp)); // 255
		System.out.println(part2(comp)); // 334
	}
	
	private static int part1(SimpleComputer comp) {
		comp.run();
		return comp.getB();
	}
	
	private static int part2(SimpleComputer comp) {
		comp.reset();
		comp.setA(1);
		comp.run();
		return comp.getB();
	}
	
	private static String[][] parseInput() {
		String[][] instructions = new String[LINES.length][3];
    	for (int i = 0; i < LINES.length; i++) {
    		String s = LINES[i];
    		instructions[i][0] = s.substring(0, 3);
    		String[] fields = s.substring(4).split(", ");
    		instructions[i][1] = fields[0];
    		instructions[i][2] = fields.length > 1 ? fields[1] : "";
    	}
    	return instructions;
	}
}
