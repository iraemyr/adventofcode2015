package net.ddns.spellbank.day21;

public class Day21RPG {
	public static void main(String[] args) {
	    int[][] weapons = new int[5][];
	    int[][] armors = new int[6][];
	    int[][] rings = new int[8][];
	    
	    weapons[0] = new int[] {8, 4, 0};
	    weapons[1] = new int[] {10, 5, 0};
	    weapons[2] = new int[] {25, 6, 0};
	    weapons[3] = new int[] {40, 7, 0};
	    weapons[4] = new int[] {74, 8, 0};
	    
	    armors[0] = new int[] {0, 0, 0};
	    armors[1] = new int[] {13, 0, 1};
	    armors[2] = new int[] {31, 0, 2};
	    armors[3] = new int[] {53, 0, 3};
	    armors[4] = new int[] {75, 0, 4};
	    armors[5] = new int[] {102, 0, 5};
	    
	    rings[0] = new int[] {0, 0, 0};
	    rings[1] = rings[0];
	    rings[2] = new int[] {20, 0, 1};
	    rings[3] = new int[] {25, 1, 0};
	    rings[4] = new int[] {40, 0, 2};
	    rings[5] = new int[] {50, 2, 0};
	    rings[6] = new int[] {80, 0, 3};
	    rings[7] = new int[] {100, 3, 0};
	    
	    // From input file
	    final int bHp = 104;
	    final int bDam = 8;
	    final int bArm = 1;
	    final int hHp = 100;
	    
	    int min_cost = Integer.MAX_VALUE;
	    int max_cost = Integer.MIN_VALUE;
	    for (int weapon = 0; weapon < weapons.length; weapon++) {
	    	int heroDam = weapons[weapon][1];
	    	int cost = weapons[weapon][0];
	    	for (int armor = 0; armor < armors.length; armor++) {
	    		cost += armors[armor][0];
	    		int heroArm = armors[armor][2];
	    		for (int ring1 = 0; ring1 < rings.length; ring1++) {
	    			cost += rings[ring1][0];
	    			heroDam += rings[ring1][1];
	    			heroArm += rings[ring1][2];
	    			for (int ring2 = ring1 + 1; ring2 < rings.length; ring2++) {
	    				cost += rings[ring2][0];
		    			heroDam += rings[ring2][1];
		    			heroArm += rings[ring2][2];
		    			if (heroWin(hHp, heroDam, heroArm, bHp, bDam, bArm))
		    				min_cost = Math.min(min_cost,  cost);
		    			else max_cost = Math.max(max_cost,  cost);
		    			cost -= rings[ring2][0];
		    			heroDam -= rings[ring2][1];
		    			heroArm -= rings[ring2][2];
	    			}
	    			cost -= rings[ring1][0];
	    			heroDam -= rings[ring1][1];
	    			heroArm -= rings[ring1][2];
	    		}
	    		cost -= armors[armor][0];
	    	}
	    }
	    System.out.println(min_cost); // 78
	    System.out.println(max_cost); // 148
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
