package com.designpatterns.command.exercise1;

public class SimpleRemoteControl {
	private Command slot;

	public SimpleRemoteControl() {

	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}
}
