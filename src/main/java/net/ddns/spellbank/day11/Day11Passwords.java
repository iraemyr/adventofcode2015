package net.ddns.spellbank.day11;


import net.ddns.spellbank.utils.InputFile;

public class Day11Passwords {

	public static void main(String[] args) {
		String file = "day11/input1";
		String[] lines = InputFile.getLines(file);
		
		String password = part1(lines[0]);
		System.out.println(password); // hxbxxyzz
		password = part1(password);
		System.out.println(password); // hxcaabcc
	}
	
	public static String part1(String password) {
		char[] pass = password.toCharArray();
		while (true) {
			incPassword(pass);
			if (isValid(pass)) break;
		}
		return new String(pass);
	}
	
	private static void incPassword(char[] password) {
		for (int i = password.length - 1; i >= 0; i--) {
			if (password[i] == 'z') password[i] = 'a';
			else {
				password[i] += 1;
				break;
			}
		}
	}
	
	private static boolean isValid(char[] password) {
		char pprev = '2';
		char prev = '1';
		boolean straight = false;
		Character r1 = null;
		Character r2 = null;
		for (char c : password) {
			if (c == 'i' || c == 'o' || c == 'l') {
				//System.out.println("Illegal character");
				return false;
			}
			if (prev == c) {
				if (r1 == null) {
					r1 = c;
					//System.out.println("Pair found: " + r1);
				} else if (r2 == null && r1 != c) {
					r2 = c;
					//System.out.println("Pair found: " + r2);
				}
			}
			if (!straight && pprev == prev - 1 && prev == c - 1) {
				straight = true;
				//System.out.println("Straight found: " + pprev + prev + c);
			}
			pprev = prev;
			prev = c;
			//System.out.println(pprev);
			//System.out.println(prev);
		}
		//if (!straight) System.out.println("No straight");
		//if (r1 == null || r2 == null) System.out.println("No unique pairs");
		return straight && r1 != null && r2 != null;
	}
}
