package com.designpatterns.state.exercise2;

public class GumballMachine {
	private GumballMachineState currentState;
	private int count = 0;

	public GumballMachine(int ballAmount) {
		this.count = ballAmount;
		if (ballAmount > 0) {
			toNoQuarterState();
		} else {
			toOutOfGumballsState();
		}
	}

	public String insertQuarter() {
		return currentState.insertQuarter();
	}

	public String ejectQuarter() {
		return currentState.ejectQuarter();
	}

	public String turnCrank() {
		String msg1 = currentState.turnCrank();
		String msg2 = currentState.dispense();
		return String.format("%s\n%s", msg1, msg2);
	}

	public void refill(int count) {
		if (count > 0) {
			this.count = count;
			toNoQuarterState();
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model");
		result.append("\nInventory: " + count + "gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is " + currentState + "\n");

		return result.toString();
	}

	public int getCount() {
		return count;
	}

	protected void toNoQuarterState() {
		currentState = new NoQuarterState(this);
	}

	protected void toHasQuarterState() {
		currentState = new HasQuarterState(this);
	}

	protected void toSoldState() {
		currentState = new SoldState(this);
	}

	protected void toOutOfGumballsState() {
		currentState = new OutOfGumballsState(this);
	}

	protected String releaseBall() {
		if (count != 0) {
			count--;
		}

		return "A gumball comes rolling out of the slot...";
	}
}
