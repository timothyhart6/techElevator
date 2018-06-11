package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {
		
		
		
		Singable[] farmAnimals = new Singable[] { new Cat(true), new Cow(false), new Chicken(true), new Tractor() };
		
		for(Singable animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a "+name+", ee, ay, ee, ay, oh!");
			System.out.println("With a "+sound+" "+sound+" here");
			System.out.println("And a "+sound+" "+sound+" there");
			System.out.println("Here a "+sound+" there a "+sound+" everywhere a "+sound+" "+sound);
			System.out.println();
		}
		
		Sellable[] sellableFarmAnimals = new Sellable[] { new Cow(true), new Chicken(false), new Apple() };
		for(Sellable animal : sellableFarmAnimals) {
			System.out.println(animal.getName() + " : " + animal.getPrice());
		}
		
		
	}
}