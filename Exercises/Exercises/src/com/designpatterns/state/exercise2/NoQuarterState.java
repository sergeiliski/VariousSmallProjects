package com.designpatterns.state.exercise2;

public class NoQuarterState extends GumballMachineState {
	protected NoQuarterState(GumballMachine machine) {
		super(machine);
	}

	@Override
	protected String insertQuarter() {
		machine.toHasQuarterState();
		return "You inserted a quarter";
	}

	@Override
	public String toString() {
		return "Waiting for quarter";
	}
}
