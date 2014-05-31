package com.designpatterns.state.exercise2;

public class SoldState extends GumballMachineState {
	public SoldState(GumballMachine machine) {
		super(machine);
	}

	@Override
	protected String dispense() {
		machine.toNoQuarterState();
		return "Here's your stuff!";
	}

	@Override
	public String toString() {
		return "Goodbye, come again!";
	}
}
