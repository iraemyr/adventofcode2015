package net.ddns.spellbank.day15;

import java.util.ArrayList;
import java.util.List;

import net.ddns.spellbank.utils.InputFile;

public class Day15CookieRecipes {
    private static int SCORE = 0;

    public static void main(String[] args) {
        String file = "day15/input1";
        String[] lines = InputFile.getLines(file);

        List<Ingredient> ingredients = parseIngredients(lines);

        System.out.println(part1(ingredients)); // 21367368
        System.out.println(part2(ingredients)); // 1766400
    }

    public static int part1(List<Ingredient> ingredients) {
        SCORE = 0;
        combine(ingredients, 0, 0, 0, 0, 0, 0);
        return SCORE;
    }

    public static int part2(List<Ingredient> ingredients) {
        SCORE = 0;
        combineCal(ingredients, 0, 0, 0, 0, 0, 0, 0);
        return SCORE;
    }

    public static List<Ingredient> parseIngredients(String[] lines) {
        List<Ingredient> ingredients = new ArrayList<>();
        for (String str : lines) {
            String[] fields = str.split(", ");
            String[] nameCap = fields[0].split(": ");
            String name = nameCap[0];
            int cap = Integer.parseInt(nameCap[1].split(" ")[1]);
            int dur = Integer.parseInt(fields[1].split(" ")[1]);
            int flav = Integer.parseInt(fields[2].split(" ")[1]);
            int tex = Integer.parseInt(fields[3].split(" ")[1]);
            int cal = Integer.parseInt(fields[4].split(" ")[1]);
            Ingredient in = new Ingredient(name, cap, dur, flav, tex, cal);
            ingredients.add(in);
        }
        return ingredients;
    }

    private static void combine(List<Ingredient> ingred, int index, int used, int cap, int dur, int flav, int tex) {
        Ingredient in = ingred.get(index);
        if (index == ingred.size() - 1) {
            int amt = 100 - used;
            cap += amt * in.capacity;
            dur += amt * in.durability;
            flav += amt * in.flavor;
            tex += amt * in.texture;
            // System.out.println(in.name + ":" + amt + " ");
            // System.out.println("cap:" + cap + " dur:" + dur + " flav:" + flav + " tex:" +
            // tex);
            // System.out.println(score(cap, dur, flav, tex));
            SCORE = Math.max(SCORE, score(cap, dur, flav, tex));
            return;
        }
        for (int i = 0; i <= 100 - used; i++) {
            int c = i * in.capacity + cap;
            int d = i * in.durability + dur;
            int f = i * in.flavor + flav;
            int t = i * in.texture + tex;
            // System.out.print(in.name + ":" + i + " ");
            combine(ingred, index + 1, i + used, c, d, f, t);
        }
    }

    private static void combineCal(List<Ingredient> ingred, int index, int used, int cap, int dur, int flav, int tex,
            int cal) {
        Ingredient in = ingred.get(index);
        if (index == ingred.size() - 1) {
            int amt = 100 - used;
            cap += amt * in.capacity;
            dur += amt * in.durability;
            flav += amt * in.flavor;
            tex += amt * in.texture;
            cal += amt * in.calories;
            if (cal == 500)
                SCORE = Math.max(SCORE, score(cap, dur, flav, tex));
            return;
        }
        for (int i = 0; i <= 100 - used; i++) {
            int c = i * in.capacity + cap;
            int d = i * in.durability + dur;
            int f = i * in.flavor + flav;
            int t = i * in.texture + tex;
            int ca = i * in.calories + cal;
            // System.out.print(in.name + ":" + i + " ");
            combineCal(ingred, index + 1, i + used, c, d, f, t, ca);
        }
    }

    private static int score(int cap, int dur, int flav, int tex) {
        if (cap < 0 || dur < 0 || flav < 0 || tex < 0)
            return 0;
        return cap * dur * flav * tex;
    }
}
