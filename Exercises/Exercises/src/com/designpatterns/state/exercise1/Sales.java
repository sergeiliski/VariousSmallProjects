package com.designpatterns.state.exercise1;

public class Sales implements Connection {
	@Override
	public void open() {
		System.out.println("Opening sales connection");
	}

	@Override
	public void close() {
		System.out.println("Closing connection");
	}

	@Override
	public void log() {
		System.out.println("Logging activities");
	}

	public void update() {
		System.out.println("Updating..");
	}
}
