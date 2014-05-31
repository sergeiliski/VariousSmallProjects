package com.designpatterns.state.exercise2;

public class HasQuarterState extends GumballMachineState {
	protected HasQuarterState(GumballMachine machine) {
		super(machine);
	}

	@Override
	protected String ejectQuarter() {
		machine.toNoQuarterState();
		return "Quarter returned";
	}

	@Override
	protected String turnCrank() {
		machine.toSoldState();
		return "You've turned...";
	}

	@Override
	public String toString() {
		return "Waiting for turn of crank...";
	}
}
