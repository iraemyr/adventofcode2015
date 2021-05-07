package net.ddns.spellbank.day04;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.ddns.spellbank.utils.InputFile;

public class Day4MD5 {

	public static void main(String[] args) {
		String file = "day04/input1";
		String[] lines = InputFile.getLines(file);
		
		System.out.println(part1(lines[0])); // 117946
		System.out.println(part2(lines[0])); // 3938038
	}
	
	public static int part1(String prefix) {
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
	
	public static int part2(String prefix) {
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
