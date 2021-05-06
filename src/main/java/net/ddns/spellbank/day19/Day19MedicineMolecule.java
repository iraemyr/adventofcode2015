package net.ddns.spellbank.day19;


import java.util.ArrayList;
import java.util.List;

import net.ddns.spellbank.utils.InputFile;

public class Day19MedicineMolecule {
	private static String[] LINES;

	public static void main(String[] args) {
		String file = "day19/input1";
		LINES = InputFile.getLines(file);
		
		List<String[]> input = new ArrayList<>();
		String molecule = parseInput(input);
		
		System.out.println(part1(input, molecule)); // 535 
		System.out.println(part2(input, molecule)); // 212
	}
	
	private static long part1(List<String[]> input, String molecule) {
		List<String> output = new ArrayList<>();
		for (String[] each : input) {
            int position = 0;
            while ((position = molecule.indexOf(each[0], position)) >= 0) {
                output.add(replace(molecule, each[0], each[1], position));
                position += each[0].length();
            }
        }

        long count = output.stream().distinct().count();
        return count;
	}
	
	private static int part2(List<String[]> input, String molecule) {
		int count = 0;
        while(!molecule.equals("e")) {
            for (String[] each : input) {
                if (molecule.contains(each[1])) {
                    molecule = replace(molecule, each[1], each[0], 
                    		           molecule.lastIndexOf(each[1]));
                    count++;
                }
            }
        }
        return count;
	}
	
	private static String parseInput(List<String[]> input) {
		int i = 0;
		while (true) {
			String str = LINES[i++];
    	    if (str.length() == 0) break;
    	    String[] fields = str.split(" => ");
    	    input.add(fields); 
        }
		return LINES[i];
	}
	
	public static String replace(String s, String in, String out, int position) {
        return s.substring(0, position) + out + s.substring(position + in.length());
    }
}
