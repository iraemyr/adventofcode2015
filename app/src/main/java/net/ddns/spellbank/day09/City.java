package net.ddns.spellbank.day09;

import java.util.ArrayList;
import java.util.List;

public class City {
	String name;
	List<CityLink> destinations;
	
	public City(String name) {
		this.name = name;
		destinations = new ArrayList<>();
	}
	
	public void addDestination(String dest, int dist) {
		destinations.add(new CityLink(dest, dist));
	}

}
