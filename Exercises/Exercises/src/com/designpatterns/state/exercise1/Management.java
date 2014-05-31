package com.designpatterns.state.exercise1;

public class Management implements Connection {
	@Override
	public void open() {
		System.out.println("Opening management connection");
	}

	@Override
	public void close() {
		System.out.println("Closing management connection");
	}

	@Override
	public void log() {
		System.out.println("Logging activities");
	}
}
