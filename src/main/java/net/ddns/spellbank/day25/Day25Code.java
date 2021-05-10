package net.ddns.spellbank.day25;

import java.math.BigInteger;

public class Day25Code {
	public static void main(String[] args) {
	   int desired_row = 2981;
	   int desired_col = 3075;
	   
	   System.out.println(part1(desired_row, desired_col)); // 9132360
	}
	
	public static String part1(int desired_row, int desired_col) {
		long exp = (desired_row + desired_col - 2) * 
				   (desired_row + desired_col - 1) / 
				   2 + desired_col - 1;
		//System.out.println(exp);
		BigInteger ex = BigInteger.valueOf(exp);
		BigInteger code = BigInteger.valueOf(20151125l);
		BigInteger mul = BigInteger.valueOf(252533l);
		BigInteger mod = BigInteger.valueOf(33554393l);
		var result = mul.modPow(ex, mod).multiply(code).mod(mod);
		return result.toString();
	}

}
