package com.designpatterns.state.exercise2;

public abstract class GumballMachineState {
	protected GumballMachine machine;

	protected GumballMachineState(GumballMachine machine) {
		this.machine = machine;
	}

	protected String insertQuarter() {
		return "You can't insert a quarter";
	}

	protected String ejectQuarter() {
		return "You haven't inserted a quarter";
	}

	protected String turnCrank() {
		return "You have to pay before you turn";
	}

	protected String dispense() {
		return "You need to pay first";
	}
}
