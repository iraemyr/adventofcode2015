package net.ddns.spellbank.day15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import net.ddns.spellbank.utils.InputFile;

public class TestDay15 {

    @Test
    public void part1() {
        String[] lines = InputFile.getLines("day15/input1");
        List<Ingredient> ingredients = Day15CookieRecipes.parseIngredients(lines);
        assertEquals(21367368, Day15CookieRecipes.part1(ingredients));
    }

    @Test
    public void part2() {
        String[] lines = InputFile.getLines("day15/input1");
        List<Ingredient> ingredients = Day15CookieRecipes.parseIngredients(lines);
        assertEquals(1766400, Day15CookieRecipes.part2(ingredients));
    }

    @Test
    public void simplePart1() {
        String[] lines = InputFile.getLines("day15/test");
        List<Ingredient> ingredients = Day15CookieRecipes.parseIngredients(lines);
        assertEquals(62842880, Day15CookieRecipes.part1(ingredients));
    }

    @Test
    public void simplePart2() {
        String[] lines = InputFile.getLines("day15/test");
        List<Ingredient> ingredients = Day15CookieRecipes.parseIngredients(lines);
        assertEquals(57600000, Day15CookieRecipes.part2(ingredients));
    }
}
