package com.designpatterns.state.exercise1;

public class Accounting implements Connection {
	@Override
	public void open() {
		System.out.println("Opening database for accounting");
	}

	@Override
	public void close() {
		System.out.println("Closing the database");
	}

	@Override
	public void log() {
		System.out.println("Log activities");
	}
}
