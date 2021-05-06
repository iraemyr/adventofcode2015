package net.ddns.spellbank.utils;

public class Tuple {
	public int x;
	public int y;
	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x=" + x + "y=" + y;
	}
	
	public boolean equals(Tuple t) {
		return x == t.x && y == t.y ? true : false;
	}
	
	public int hashCode() {
		return toString().hashCode();
	}
}
