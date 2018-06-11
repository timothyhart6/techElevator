package com.techelevator.farm;

public final class Cat extends FarmAnimal implements Singable{

	public Cat(boolean asleep) {
		super("Cat", "meow!", 0d, asleep);
	}

	@Override
	public int eat() {
		// TODO Auto-generated method stub
		return 0;
	}


}
