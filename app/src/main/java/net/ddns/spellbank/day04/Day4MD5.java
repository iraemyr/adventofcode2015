package net.ddns.spellbank.day04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.ddns.spellbank.utils.InputFile;

public class Day4MD5 {
	private static String[] LINES;

	public static void main(String[] args) {
		String file = "day04/input1";
		LINES = InputFile.getLines(file);
		
		System.out.println(part1(LINES[0])); // 117946
		System.out.println(part2(LINES[0])); // 3938038
	}
	
	private static int part1(String prefix) {
		int i = 0;
	    MessageDigest md = null;
	    try {
	        md = MessageDigest.getInstance("MD5");
	    } catch (NoSuchAlgorithmException e) {
	    	System.out.println("MD5 unavailable");
	    }
	    while (true) {
	    	String pass = prefix + i;
	    	md.update(pass.getBytes());
	    	byte[] digest = md.digest();
	    	if (digest[0] == 0 && digest[1] == 0 && (digest[2] & 0xf0) == 0) break;
	    	i++;
	    }
		return i;
	}
	
	private static int part2(String prefix) {
		int i = 0;
	    MessageDigest md = null;
	    try {
	        md = MessageDigest.getInstance("MD5");
	    } catch (NoSuchAlgorithmException e) {
	    	System.out.println("MD5 unavailable");
	    }
	    while (true) {
	    	String pass = prefix + i;
	    	md.update(pass.getBytes());
	    	byte[] digest = md.digest();
	    	if (digest[0] == 0 && digest[1] == 0 && digest[2] == 0) break;
	    	i++;
	    }
		return i;
	}
}
