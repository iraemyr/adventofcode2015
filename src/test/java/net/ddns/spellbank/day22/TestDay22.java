package net.ddns.spellbank.day22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestDay22 {

    @Test
    void part1() {
        assertEquals(953, Day22RPGWiz.part1(55, 50, 500));
    }

    @Test
    void part2() {
        assertEquals(1289, Day22RPGWiz.part2(55, 50, 500));
    }
}
