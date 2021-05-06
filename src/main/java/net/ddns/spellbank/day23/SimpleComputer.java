package net.ddns.spellbank.day23;

public class SimpleComputer {
	private int a = 0; // Register a
	private int b = 0; // Register b
	private int pc = 0; // Program counter
	private String[][] instructions;
	
	public SimpleComputer(String[][] instructions) {
		this.instructions = instructions;
	}
	
	public void reset() {
		a = 0;
		b = 0;
		pc = 0;
	}
	
	public void setA(int a) {
		this.a = a;
	}
	
	public void setB(int b) {
		this.b = b;
	}
	
	public int getA() {
		return a;
	}
	
	public int getB() {
		return b;
	}
	
	public void run() {
		int t; // Test register
	    while (pc < instructions.length) {
	    	String[] instruction = instructions[pc];
	    	switch (instruction[0]) {
	    	case "hlf" :
	    		if (instruction[1].equals("a")) a = a / 2;
	    		else b = b / 2;
	    		pc++;
	    		break;
	    	case "tpl" :
	    		if (instruction[1].equals("a")) a = a * 3;
	    		else b = b * 3;
	    		pc++;
	    		break;
	    	case "inc" :
	    		if (instruction[1].equals("a")) a++;
	    		else b++;
	    		pc++;
	    		break;
	    	case "jmp" :
	    		int offset = Integer.parseInt(instruction[1]);
	    		pc += offset;
	    		break;
	    	case "jie" :
	    		t = instruction[1].equals("a") ? a : b;
	    		if (t % 2 == 0) pc += Integer.parseInt(instruction[2]);
	    		else pc++;
	    		break;
	    	case "jio" :
	    		t = instruction[1].equals("a") ? a : b;
	    		if (t == 1) pc += Integer.parseInt(instruction[2]);
	    		else pc++;
	    		break;
	    	default :
	    		System.out.println("Panic: Unsupported Instruction");
	    	}
	    }
	}

}
