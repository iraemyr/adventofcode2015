package net.ddns.spellbank.day12;


import net.ddns.spellbank.utils.InputFile;

public class Day12JSON {
	private static String[] LINES;
	private static int INDEX = 1;

	public static void main(String[] args) {
		String file = "day12/input1";
		LINES = InputFile.getLines(file);
		
		System.out.println(part1(LINES[0])); // 111754
		System.out.println(part2(LINES[0])); // 65402
	}
	
	private static int part1(String json) {
		int sum = 0;
	    int begin = -1;
	    for (int i = 0; i < json.length(); i++) {
	    	char c = json.charAt(i);
	    	if (Character.isDigit(c) || c == '-') {
	    		begin = i++;
	    	    while (Character.isDigit(json.charAt(i))) i++;
	    	    int val = 0;
	    	    val = Integer.parseInt(json.substring(begin, i));
	    	    sum += val;
	    	}
	    }
	    return sum;
	}
	
	private static int part2(String json) {
		int sum = 0;
	    if (json.charAt(0) == '[') sum = sumArray(json);
	    else sum = sumObject(json);
	    return sum;
	}
	
	private static int sumObject(String json) {
		int begin = -1;
		int sum = 0;
		boolean red = false;
		char c = json.charAt(INDEX);
        while (c != '}') {
        	if (Character.isDigit(c) || c == '-') {
	    		begin = INDEX++;
	    	    while (Character.isDigit(json.charAt(INDEX))) INDEX++;
	    	    int val = 0;
	    	    val = Integer.parseInt(json.substring(begin, INDEX--));
	    	    sum += val;
	    	} else if (c == '{') {
	    		INDEX++;
	    		sum += sumObject(json);
	    	} else if (c == '[') {
	    		INDEX++;
	    		sum += sumArray(json);
	    	} else if (c == 'd' 
	    			   && json.charAt(INDEX - 1) == 'e' 
	    			   && json.charAt(INDEX - 2) == 'r') red = true;
	    	c = json.charAt(++INDEX);
		}
        return red ? 0 : sum;
	}
	
	private static int sumArray(String json) {
		int begin = -1;
		int sum = 0;
		char c = json.charAt(INDEX);
        while (c != ']') {
        	if (Character.isDigit(c) || c == '-') {
	    		begin = INDEX++;
	    	    while (Character.isDigit(json.charAt(INDEX))) INDEX++;
	    	    int val = 0;
	    	    val = Integer.parseInt(json.substring(begin, INDEX--));
	    	    sum += val;
	    	} else if (c == '{') {
	    		INDEX++;
	    		sum += sumObject(json);
	    	} else if (c == '[') {
	    		INDEX++;
	    		sum += sumArray(json);
	    	}
        	c = json.charAt(++INDEX);
		}
        return sum;
	}
}
