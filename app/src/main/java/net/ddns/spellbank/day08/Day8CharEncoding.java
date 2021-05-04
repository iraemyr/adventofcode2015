package net.ddns.spellbank.day08;


import net.ddns.spellbank.utils.InputFile;

public class Day8CharEncoding {
	private static String[] LINES;

	public static void main(String[] args) {
		String file = "day08/input1";
		LINES = InputFile.getLines(file);
		
		System.out.println(part1()); // 1342
		System.out.println(part2()); // 2074
	}
	
	private static int part1() {
		int code = 0;
	    int mem = 0;
	    for (String str : LINES) {
    	    code += str.length();
    	    int m = -2;
    	    char[] st = str.toCharArray();
    	    for (int i = 0; i < st.length; i++) {
    	    	if (st[i] == '\\') {
    	    		if (st[i + 1] == 'x') i += 3;
    	    		else i++;
    	    	}
    	    	m++;
    	    }
    	    mem += m;
        }
		return code - mem;
	}
	
	private static int part2() {
		int code = 0;
	    int mem = 0;
	    for (String str : LINES) {
    	    code += str.length();
    	    int m = 2;
    	    char[] st = str.toCharArray();
    	    for (int i = 0; i < st.length; i++) {
    	    	if (st[i] == '"' || st[i] == '\\') {
    	    		m++;
    	    	}
    	    	m++;
    	    }
    	    mem += m;
        }
	    return mem - code;
	}
}
