package net.ddns.spellbank.day13;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.ddns.spellbank.utils.InputFile;

public class Day13Seating {
	private static String[] LINES;
	private static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) {
		String file = "day13/input1";
		LINES = InputFile.getLines(file);
		
		Map<String, Map<String, Integer>> pref = buildPreferences();
	    Set<String> people = new HashSet<>(pref.keySet());
		System.out.println(part1(pref, people)); // 618
		System.out.println(part2(pref, people)); // 601
	}
	
	private static int part1(Map<String, Map<String, Integer>> pref, Set<String> people) {
		String[] seating = new String[pref.size()];
		doSeating(pref, people, seating, 0);
		return MAX;
	}
	
	private static int part2(Map<String, Map<String, Integer>> pref, Set<String> people) {
		MAX = Integer.MIN_VALUE;
	    people.add("myself");
	    String[] seating = new String[people.size()];
	    doSeating(pref, people, seating, 0);
		return MAX;
	}
	
	private static Map<String, Map<String, Integer>> buildPreferences() {
		Map<String, Map<String, Integer>> pref = new HashMap<>();
		for (String str : LINES) {
    	    String[] fields = str.split(" ");
    	    String name = fields[0];
    	    Map<String, Integer> m = pref.getOrDefault(name, new HashMap<>());
    	    char gainLoss = fields[2].charAt(0);
    	    int val = Integer.parseInt(fields[3]);
    	    if (gainLoss == 'l') val = -val;
    	    String name2 = fields[fields.length - 1];
    	    name2 = name2.substring(0, name2.length() - 1); 
    	    m.put(name2,  val);
    	    pref.put(name, m);
        }
		return pref;
	}
	
	private static void doSeating(Map<String, Map<String, Integer>> pref, 
			                      Set<String> people, String[] seating, int index) {
		if (people.isEmpty()) {
			score(pref, seating);
			return;
		}
		String[] p = people.toArray(new String[0]);
		for (int i = 0; i < p.length; i++) {
			seating[index] = p[i];
			people.remove(p[i]);
			doSeating(pref, people, seating, index + 1);
			people.add(p[i]);
		}
	}
	
	private static void score(Map<String, Map<String, Integer>> pref, String[] seating) {
		int sum = 0;
		for (int i = 0; i < seating.length; i++) {
			if (seating[i].equals("myself")) continue;
			var m = pref.get(seating[i]);
			sum += i == 0 ? m.getOrDefault(seating[seating.length - 1], 0) : m.getOrDefault(seating[i - 1], 0);
			sum += i == seating.length - 1 ? m.getOrDefault(seating[0], 0) : m.getOrDefault(seating[i + 1], 0);
		}
		MAX = Math.max(MAX, sum);
	}
}
