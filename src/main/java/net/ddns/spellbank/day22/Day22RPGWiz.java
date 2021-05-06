package net.ddns.spellbank.day22;

public class Day22RPGWiz {
	private static final int bDam = 8;
	private static final int MM_DAM = 4;
	private static final int MM_COST = 53;
	private static final int DRAIN_DAM = 2;
	private static final int DRAIN_COST = 73;
	private static final int SHIELD_ARM = 7;
	private static final int SHIELD_COST = 113;
	private static final int SHIELD_DUR = 6;
	private static final int POISON_DAM = 3;
	private static final int POISON_COST = 173;
	private static final int POISON_DUR = 6;
	private static final int RECHARGE_MANA = 101;
	private static final int RECHARGE_COST = 229;
	private static final int RECHARGE_DUR = 5;
	private static int min = Integer.MAX_VALUE;
	private static final String[] spells = {"mm", "drain", "shield", "poison", "recharge"};
	
	public static void main(String[] args) {
		final int bHp = 55;
	    final int hHp = 50;
	    final int hMan = 500;
	    
	    simCombat(true, bHp, hHp, hMan, 0, 0, 0, 0, false);
	    System.out.println(min);
	    min = Integer.MAX_VALUE;
	    simCombat(true, bHp, hHp, hMan, 0, 0, 0, 0, true);
	    System.out.println(min);
	}
	
	private static void simCombat(boolean player, int bHp, int hHp, int mana, int used, 
			                      int shield, int poison, int recharge, boolean hard) {
		if (used > min) return;
		if (player && hard) {
			hHp--;
			if (hHp < 1) return;
		}
		
		// Apply effects
		boolean armor = (shield-- > 0);
		if (poison-- > 0) bHp -= POISON_DAM;
		if (bHp < 1) {
			min = Math.min(min,  used);
			return;
		}
		if (recharge-- > 0) mana += RECHARGE_MANA;
		
		if (player) {
		    boolean actionTaken = false;
		    int u;
		    int bhp;
		    for (String s : spells) {
			    switch(s) {
			    case "mm" :
				    if (mana < MM_COST) continue;
				    actionTaken = true;
				    u = used + MM_COST;
				    bhp = bHp - MM_DAM;
				    if (bhp < 1) {
				    	min = Math.min(min, u);
				    	return;
				    }
				    simCombat(false, bhp, hHp, mana - MM_COST, u, shield, poison, recharge, hard);
				    break;
			    case "drain" :
				    if (mana < DRAIN_COST) continue;
				    actionTaken = true;
				    u = used + DRAIN_COST;
				    bhp = bHp - DRAIN_DAM;
				    if (bhp < 1) {
				    	min = Math.min(min, u);
				    	return;
				    }
				    simCombat(false, bhp, hHp + DRAIN_DAM, mana - DRAIN_COST, u, shield, poison, recharge, hard);
				    break;
			    case "shield" :
				    if (shield > 0 || mana < SHIELD_COST) continue;
				    actionTaken = true;
				    u = used + SHIELD_COST;
				    simCombat(false, bHp, hHp, mana - SHIELD_COST, u, SHIELD_DUR, poison, recharge, hard);
				    break;
			    case "poison" :
			    	if (poison > 0 || mana < POISON_COST) continue;
			    	actionTaken = true;
			    	u = used + POISON_COST;
			    	simCombat(false, bHp, hHp, mana - POISON_COST, u, shield, POISON_DUR, recharge, hard);
				    break;
			    case "recharge" :
			    	if (recharge > 0 || mana < RECHARGE_COST) continue;
			    	actionTaken = true;
			    	u = used + RECHARGE_COST;
			    	simCombat(false, bHp, hHp, mana - RECHARGE_COST, u, shield, poison, RECHARGE_DUR, hard);
			    default:
				    break;
			    }
		    }
		    if (!actionTaken) return;
		} else {
			hHp -= armor ? bDam - SHIELD_ARM : bDam;
			if (hHp < 1) return;
			simCombat(true, bHp, hHp, mana, used, shield, poison, recharge, hard);
		}
		
	}

}
