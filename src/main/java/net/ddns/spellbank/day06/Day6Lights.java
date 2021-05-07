package net.ddns.spellbank.day06;


import net.ddns.spellbank.utils.InputFile;

public class Day6Lights {

	public static void main(String[] args) {
		String file = "day06/input1";
		String[] lines = InputFile.getLines(file);
		
		System.out.println(part1(lines)); // 377891
		System.out.println(part2(lines)); // 14110788
	}
	
	public static int part1(String[] lines) {
		boolean[][] lights = new boolean[1000][1000];
	    int numOn = 0;
	    String origin, dest;
	    for (String s : lines) {
        	String[] fields = s.split(" ");
        	if (fields[0].equals("toggle")) {
        		origin = fields[1];
        		dest = fields[3];
        	} else {
        		origin = fields[2];
        		dest = fields[4];
        	}
        	String[] coords = origin.split(",");
        	int originx = Integer.parseInt(coords[0]);
        	int originy = Integer.parseInt(coords[1]);
        	coords = dest.split(",");
        	int destx = Integer.parseInt(coords[0]);
        	int desty = Integer.parseInt(coords[1]);
        	int mode;
        	if (fields[0].equals("toggle")) mode = 0; 
        	else if (fields[1].equals("on")) mode = 1;
        	else mode = 2;
        	doLights(originx, originy, destx, desty, lights, mode);
        }
	    for (boolean[] row : lights)
	    	for (boolean b : row) if (b) numOn++;
		return numOn;
	}
	
	public static int part2(String[] lines) {
		int[][] lights = new int[1000][1000];
	    int brightness = 0;
	    String origin, dest;
	    for (String s : lines) {
        	String[] fields = s.split(" ");
        	if (fields[0].equals("toggle")) {
        		origin = fields[1];
        		dest = fields[3];
        	} else {
        		origin = fields[2];
        		dest = fields[4];
        	}
        	String[] coords = origin.split(",");
        	int originx = Integer.parseInt(coords[0]);
        	int originy = Integer.parseInt(coords[1]);
        	coords = dest.split(",");
        	int destx = Integer.parseInt(coords[0]);
        	int desty = Integer.parseInt(coords[1]);
        	int mode;
        	if (fields[0].equals("toggle")) mode = 0; 
        	else if (fields[1].equals("on")) mode = 1;
        	else mode = 2;
        	doLightsBright(originx, originy, destx, desty, lights, mode);
        }
	    
	    for (int[] row : lights)
	    	for (int a : row) brightness += a;
		return brightness;
	}
	
	private static void doLights(int originx, int originy, int destx, int desty, 
            boolean[][] lights, int mode) {
        // Mode 0 - toggle
        // Mode 1 - On
        // Mode 2 - Off
        for (int i = originx; i <= destx; i++) {
            for (int j = originy; j <= desty; j++) {
                if (mode == 0) lights[i][j] = !lights[i][j];
                else if (mode == 1) lights[i][j] = true;
                else lights[i][j] = false;
            }
        }
    }
	
	private static void doLightsBright(int originx, int originy, int destx, int desty, 
            int[][] lights, int mode) {
        // Mode 0 - toggle
        // Mode 1 - On
        // Mode 2 - Off
        for (int i = originx; i <= destx; i++) {
            for (int j = originy; j <= desty; j++) {
                if (mode == 0) lights[i][j] += 2;
                else if (mode == 1) lights[i][j] += 1;
                else {
                    if (lights[i][j] > 0) lights[i][j]--;
                }
            }
        }
    }
}