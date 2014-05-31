package com.designpatterns.command.exercise1;

public class RemoteControl {
	private Command[] onCommands;
	private Command[] offCommands;
	private final int numberCommands = 7;

	public RemoteControl() {
		onCommands = new Command[numberCommands];
		offCommands = new Command[numberCommands];

		Command noCommand = new NoCommand();
		for (int i = 0; i < numberCommands; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
	}

	@Override
	public String toString() {
		return "...";
	}
}
