package net.ddns.spellbank.day18;


import java.util.ArrayList;
import java.util.List;

import net.ddns.spellbank.utils.InputFile;
import net.ddns.spellbank.utils.Point;

public class Day18LightsMap {
	private static String[] LINES;
	private static List<Point> UPD = new ArrayList<>();

	public static void main(String[] args) {
		String file = "day18/input1";
		LINES = InputFile.getLines(file);
		
		char[][] map = parseMap();
		char[][] map2 = copyMap(map);
	    
		System.out.println(part1(map)); // 814
		System.out.println(part2(map2)); // 924
	}
	
	private static int part1(char[][] map) {
		for (int i = 0; i < 100; i++) update(map);
	    int on = 0;
	    for (char[] m : map)
	    	for (char c : m) if (c == '#') on++;
		return on;
	}
	
	private static int part2(char[][] map) {
		for (int i = 0; i < 100; i++) {
	    	stuckOn(map);
	    	update(map);
	    }
	    stuckOn(map);
	    int on = 0;
	    for (char[] m : map)
	    	for (char c : m) if (c == '#') on++;
	    return on;
	}
	
	private static char[][] parseMap() {
		char[][] map = null;
		int row = 0;
		for (String str : LINES) {
        	if (map == null) map = new char[str.length()][str.length()];
    	    for (int i = 0; i < str.length(); i++) {
    	    	map[row][i] = str.charAt(i);
    	    }
    	    row++;
        }
		return map;
	}
	
	private static void update(char[][] map) {
		UPD.clear();
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[row].length; col++) {
				int count = countOn(map, row, col);
				char c = map[row][col];
				if (c == '#' && (count < 2 || count > 3))
					UPD.add(new Point(row, col, '.'));
				else if (c == '.' && count == 3)
					UPD.add(new Point(row, col, '#'));
			}	
		}
		for (Point p : UPD) map[p.x][p.y] = p.c;
	}
	
	private static int countOn(char[][] map, int row, int col) {
		int count = 0;
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (i == 0 && j == 0) continue;
				if (row + i >= 0 && row + i < map.length && 
					col + j >= 0 && col + j < map[row + i].length && 
					map[row + i][col + j] == '#') count++;
			}
		}
		return count;
	}
	
	private static char[][] copyMap(char[][] map) {
		char[][] copy = new char[map.length][map[0].length];
		for (int row = 0; row < map.length; row++)
			for (int col = 0; col < map[row].length; col++) 
				copy[row][col] = map[row][col];
		return copy;
	}
	
	private static void stuckOn(char[][] map) {
		map[0][0] = '#';
		map[0][map[0].length - 1] = '#';
		map[map.length - 1][0] = '#';
		map[map.length - 1][map[0].length - 1] = '#';
	}
}
