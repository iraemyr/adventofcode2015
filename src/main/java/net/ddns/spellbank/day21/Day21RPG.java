package net.ddns.spellbank.day21;

public class Day21RPG {
	private static final int[][] WEAPONS =  {{8, 4, 0},
			                                 {10, 5, 0},
			                                 {25, 6, 0},
			                                 {40, 7, 0},
			                                 {74, 8, 0}};
	
	private static final int[][] ARMORS = {{0, 0, 0},
			                               {13, 0, 1},
			                               {31, 0, 2},
			                               {53, 0, 3},
			                               {75, 0, 4},
			                               {102, 0, 5}};
	
	private static final int[][] RINGS = {{0, 0, 0},
			                              {0, 0, 0},
			                              {20, 0, 1},
			                              {25, 1, 0},
			                              {40, 0, 2},
			                              {50, 2, 0},
			                              {80, 0, 3},
			                              {100, 3, 0}};
	
	private static int MIN;
	private static int MAX;
	
	public static void main(String[] args) {
	    
	    // From input file
	    final int bHp = 104;
	    final int bDam = 8;
	    final int bArm = 1;
	    final int hHp = 100;
	    evalEquipment(bHp, bDam, bArm, hHp);
	    
	    
	    System.out.println(part1()); // 78
	    System.out.println(part2()); // 148
	}
	
	public static int part1() {
		return MIN;
	}
	
	public static int part2() {
		return MAX;
	}
	
	public static void evalEquipment(int bHp, int bDam, int bArm, int hHp) {
		MIN = Integer.MAX_VALUE;
	    MAX = Integer.MIN_VALUE;
	    for (int weapon = 0; weapon < WEAPONS.length; weapon++) {
	    	int heroDam = WEAPONS[weapon][1];
	    	int cost = WEAPONS[weapon][0];
	    	for (int armor = 0; armor < ARMORS.length; armor++) {
	    		cost += ARMORS[armor][0];
	    		int heroArm = ARMORS[armor][2];
	    		for (int ring1 = 0; ring1 < RINGS.length; ring1++) {
	    			cost += RINGS[ring1][0];
	    			heroDam += RINGS[ring1][1];
	    			heroArm += RINGS[ring1][2];
	    			for (int ring2 = ring1 + 1; ring2 < RINGS.length; ring2++) {
	    				cost += RINGS[ring2][0];
		    			heroDam += RINGS[ring2][1];
		    			heroArm += RINGS[ring2][2];
		    			if (heroWin(hHp, heroDam, heroArm, bHp, bDam, bArm))
		    				MIN = Math.min(MIN,  cost);
		    			else MAX = Math.max(MAX,  cost);
		    			cost -= RINGS[ring2][0];
		    			heroDam -= RINGS[ring2][1];
		    			heroArm -= RINGS[ring2][2];
	    			}
	    			cost -= RINGS[ring1][0];
	    			heroDam -= RINGS[ring1][1];
	    			heroArm -= RINGS[ring1][2];
	    		}
	    		cost -= ARMORS[armor][0];
	    	}
	    }
	}
	
	private static boolean heroWin(int heroHp, int heroDam, int heroArm, 
			                       int bHp, int bDam, int bArm) {
		boolean h = true;
		heroDam -= bArm;
		if (heroDam < 1) heroDam = 1;
		bDam -= heroArm;
		if (bDam < 1) bDam = 1;
		while (heroHp > 0 && bHp > 0) {
			if (h) {
				bHp -= heroDam;
				h = false;
			} else {
				heroHp -= bDam;
				h = true;
			}
		}
		return heroHp > 0;
	}

}
