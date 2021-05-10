package net.ddns.spellbank.day21;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestDay21 {

    @Test
    void part1() {
        final int bHp = 104;
        final int bDam = 8;
        final int bArm = 1;
        final int hHp = 100;
        Day21RPG.evalEquipment(bHp, bDam, bArm, hHp);
        assertEquals(78, Day21RPG.part1());
    }

    @Test
    void part2() {
        final int bHp = 104;
        final int bDam = 8;
        final int bArm = 1;
        final int hHp = 100;
        Day21RPG.evalEquipment(bHp, bDam, bArm, hHp);
        assertEquals(148, Day21RPG.part2());
    }
}
