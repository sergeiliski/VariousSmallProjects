package com.designpatterns.strategy.exercise3;

public class StartUp {
	public static void main(String[] args) {
		Character king = new King("George");
		Character troll = new Troll("Franky");
		Character queen = new Queen("Victoria");

		System.out.println(king.printWeapon());
		System.out.println(king.showInfo());

		System.out.println(troll.printWeapon());
		System.out.println(troll.showInfo());

		System.out.println(queen.printWeapon());
		System.out.println(queen.showInfo());

		king.setWeapon(new Bow());
		System.out.println(king.printWeapon());
	}
}
