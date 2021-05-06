package net.ddns.spellbank.day15;

public class Ingredient {
	String name;
	int capacity;
	int durability;
	int flavor;
	int texture;
	int calories;

	public Ingredient(String name, int cap, int dur, int flav, int tex, int cal) {
		this.name = name;
		capacity = cap;
		durability = dur;
		flavor = flav;
		texture = tex;
		calories = cal;
	}
	
	public void print() {
		System.out.println(name + " " + capacity + " " + durability + " " 
	                       + flavor + " " + texture + " " + calories);
	}
}
