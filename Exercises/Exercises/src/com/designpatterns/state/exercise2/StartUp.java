package com.designpatterns.state.exercise2;

public class StartUp {
	public static void main(String[] args) {
		GumballMachine machine = new GumballMachine(5);
		System.out.println(machine);

		System.out.println(machine.insertQuarter());
		System.out.println(machine.turnCrank());
		System.out.println(machine);

		System.out.println(machine.insertQuarter());
		System.out.println(machine.ejectQuarter());
		System.out.println(machine.turnCrank());
		System.out.println(machine);
	}
}
